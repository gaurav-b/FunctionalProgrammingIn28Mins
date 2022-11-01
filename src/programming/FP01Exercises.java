package programming;

import java.util.List;

public class FP01Exercises {

public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
//		printOddNumbersInListFunctional(numbers);
//		printCubesOfOddNumbers(numbers);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
										"PCF", "Azure", "Docker", "Kubernetes");
		
//		printAllCoursesIndividually(courses);
//		printAllCoursesWithSpringWord(courses);
//		printAllCoursesWithAtleastFourLetters(courses);
		printNumberOfCharsInCourseName(courses);
	}

	private static void printNumberOfCharsInCourseName(List<String> courses) {
		
		courses.stream()
			.map(course -> course + " : " + course.length())
			.forEach(System.out::println);
	}

	private static void printCubesOfOddNumbers(List<Integer> numbers) {
	
		numbers.stream()
			.filter(num -> num%2!=0)
			.map(num -> num*num*num)
			.forEach(System.out::println);
	}

	private static void printAllCoursesWithAtleastFourLetters(List<String> courses) {
		courses.stream()
			.filter(course -> course.length()>=4)
			.forEach(System.out::println);
	}

	private static void printAllCoursesWithSpringWord(List<String> courses) {
		courses.stream()
//			.filter(course -> course.indexOf("Spring")!=-1)
			.filter(course -> course.contains("Spring"))
			.forEach(System.out::println);
	}

	private static void printAllCoursesIndividually(List<String> courses) {
		courses.stream().forEach(System.out::println);		
	}

	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.filter(num -> num%2 != 0) // Lambda expression - a method without body
		.forEach(System.out::println);
	}

}
