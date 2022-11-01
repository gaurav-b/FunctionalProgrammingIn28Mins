package programming;

import java.util.Comparator;
import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
//		printAllNumbersInListNonFunctional(numbers);
//		printAllNumbersInListFunctional(numbers);
//		printEvenNumbersInListStructured(numbers);
//		printEvenNumbersInListFunctional(numbers);
//		printOddNumbersInListFunctional(numbers);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
		
//		printAllCoursesIndividually(courses);
//		printAllCoursesWithSpringWord(courses);
//		printAllCoursesWithAtleastFourLetters(courses);
//		printSquaresOfEvenNumbersInListFunctional(numbers);
		
		courses.stream()
			.sorted(Comparator.comparing(str -> str.length(), Comparator.reverseOrder()))
			.forEach(System.out::println);
	}

	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.filter(num -> num%2==0)
			.map(num -> num*num)
			.forEach(System.out::println);
	}

	private static void printAllCoursesWithAtleastFourLetters(List<String> courses) {
		courses.stream()
			.filter(course -> course.length()>=4)
			.forEach(System.out::println);
	}

	private static void printAllCoursesWithSpringWord(List<String> courses) {
		courses.stream()
			.filter(course -> course.indexOf("Spring")!=-1)
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

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.filter(num -> num%2 == 0) // Lambda expression - a method without body
			.forEach(System.out::println);
		
	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		for (int number : numbers) {
			if (number%2==0) {
				System.out.println(number);
			}
		}
	}

	private static void print(int number) {
		System.out.println(number);
	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		
		// numbers.stream().forEach(FP01Structured::print); // :: is method reference
		numbers.stream().forEach(System.out::println);
	}
	
	private static void printAllNumbersInListNonFunctional(List<Integer> numbers) {
		
		for (int number : numbers) {
			System.out.println(number);
		}
	}
}
