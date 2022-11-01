package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
//		int sum = addListFunctional(numbers);
//		System.out.println("sum : " + sum);
		
//		List<Integer> doubledNumbers = doubleList(numbers);
//		System.out.println(doubledNumbers);
		
//		List<Integer> evenNumbers = evenNumbersList(numbers);
//		System.out.println(evenNumbers);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
				"PCF", "Azure", "Docker", "Kubernetes");
		
		List<Integer> lengthOfCourses = coursesLengthList(courses);
		System.out.println(lengthOfCourses);
		
	}


	private static List<Integer> coursesLengthList(List<String> courses) {
		return courses.stream()
				.map(c -> c.length())
				.collect(Collectors.toList());
	}


	private static List<Integer> evenNumbersList(List<Integer> numbers) {
		return numbers.stream()
				.filter(n -> n%2==0)
				.collect(Collectors.toList());
	}

	private static List<Integer> doubleList(List<Integer> numbers) {
		return numbers.stream()
				.map(n -> n*n)
				.collect(Collectors.toList());
	}

	private static int addListFunctional(List<Integer> numbers) {
		// we can use reduce in following ways
		
		// aggregate - computation of 2 numbers which will generate next number
		// nextNumber - is the next number in the list
		
		// this
//		return numbers.stream()
//			.reduce((aggregate,nextNumber) -> aggregate+nextNumber)
//			.get();
		
		// or this
//		return numbers.stream()
//				.reduce(0, (aggregate, nextNumber) -> aggregate+nextNumber);
		
		// or this
		return numbers.stream()
				.reduce(0, Integer::sum);
	}

}
