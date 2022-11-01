package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	
	@Override
	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
}

public class FP04CustomClass {

	public static void main(String[] args) {

		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000)
		);
		
		// allMatch, noneMatch, anyMatch
		Predicate<? super Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore()>95;
		Predicate<? super Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore()>90;
		
		Predicate<? super Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore()<90;
		
		System.out.println(courses.stream()
				.allMatch(reviewScoreGreaterThan95Predicate));
		
		System.out.println(courses.stream()
				.noneMatch(reviewScoreLessThan90Predicate));
		
		System.out.println(courses.stream()
				.anyMatch(reviewScoreLessThan90Predicate));
		
		System.out.println(courses.stream()
				.anyMatch(reviewScoreGreaterThan95Predicate));
		
		// sort courses
		
		// NOTE : for primitive comparisions we can use comparingInt, comparingDouble and so on
		// to make it more efficient coz then the autoboxing and unboxing will move out from the picture
		
		Comparator comparingByNoOfStrudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
		System.out.println(courses.stream()
							.sorted(comparingByNoOfStrudentsIncreasing)
							.collect(Collectors.toList()));
		
		
		Comparator comparingByNoOfStrudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream()
							.sorted(comparingByNoOfStrudentsDecreasing)
							.collect(Collectors.toList()));
		
		Comparator comparingByNoOfStrudentsAndNoOfReviews = 
				Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore)
				.reversed();
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStrudentsAndNoOfReviews)
				.collect(Collectors.toList()));
		
		// skip, limit, takeWhile, dropWHile
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStrudentsAndNoOfReviews)
				.limit(5)
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStrudentsAndNoOfReviews)
				.skip(3)
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStrudentsAndNoOfReviews)
				.skip(3).limit(5)
				.collect(Collectors.toList()));
		
		System.out.println(courses);
		
		System.out.println(courses.stream()
				.takeWhile(course -> course.getReviewScore()>=95)
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.dropWhile(course -> course.getReviewScore()>=95)
				.collect(Collectors.toList()));

		// min, max, findFirst, findAny
		System.out.println(courses.stream()
				.max(comparingByNoOfStrudentsAndNoOfReviews));
		
		System.out.println(courses.stream()
				.min(comparingByNoOfStrudentsAndNoOfReviews)
				.orElse(new Course("Kubernetes","Cloud", 91, 20000)));
	
		System.out.println(courses.stream()
				.filter(reviewScoreLessThan90Predicate)
				.min(comparingByNoOfStrudentsAndNoOfReviews)
				.orElse(new Course("Kubernetes","Cloud", 91, 20000)));
		
		System.out.println(
				courses.stream()
					.filter(reviewScoreLessThan90Predicate)
					.findFirst());
		
		System.out.println(
				courses.stream()
					.filter(reviewScoreGreaterThan95Predicate)
					.findFirst());
		
		System.out.println(
				courses.stream()
					.filter(reviewScoreGreaterThan95Predicate)
					.findAny());
		
		// sum, average nd count
		System.out.println(
				courses.stream()
					.filter(reviewScoreGreaterThan95Predicate)
					.mapToInt(Course::getNoOfStudents)
					.sum());
		
		System.out.println(
				courses.stream()
					.filter(reviewScoreGreaterThan95Predicate)
					.mapToInt(Course::getNoOfStudents)
					.average());
		
		System.out.println(
				courses.stream()
					.filter(reviewScoreGreaterThan95Predicate)
					.mapToInt(Course::getNoOfStudents)
					.count());
		
		System.out.println(
				courses.stream()
					.filter(reviewScoreGreaterThan95Predicate)
					.mapToInt(Course::getNoOfStudents)
					.max());
		
		System.out.println(
				courses.stream()
					.filter(reviewScoreGreaterThan95Predicate)
					.mapToInt(Course::getNoOfStudents)
					.min());
		
		// groupingBy
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory))
				);
		
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
				);
		
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory, 
								Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
				);
		
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory, 
								Collectors.mapping(Course::getName, Collectors.toList())))
				);
		
		Predicate<? super Course> reviewScoreGreaterThan95Predicate2 
			= createPredicateWithCutOffReviewScore(95);
			
		Predicate<? super Course> reviewScoreGreaterThan90Predicate2 
			= createPredicateWithCutOffReviewScore(90);
		
	}

	// example of higher order function
	private static Predicate<? super Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
		return course -> course.getReviewScore()>cutOffReviewScore;
	}
}
