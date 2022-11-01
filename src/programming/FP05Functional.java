package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP05Functional {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
				"PCF", "Azure", "Docker", "Kubernetes");
		
		List<String> dupCourses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
				"PCF", "Azure", "Docker", "Kubernetes");
		
		System.out.println(
				courses.stream()
					.collect(Collectors.joining(" ")));
		
		System.out.println(
				courses.stream()
					.collect(Collectors.joining(", ")));
		
		System.out.println("Spring".split(""));
		Stream.of("Spring".split("")).forEach(System.out::print);
		
		System.out.println(
				courses.stream()
					.map(course -> course.split(""))
					.collect(Collectors.toList()));
		
		System.out.println(
				courses.stream()
					.map(course -> course.split(""))
					.flatMap(Arrays::stream)
					.collect(Collectors.toList()));
		
		System.out.println(
				courses.stream()
					.map(course -> course.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.collect(Collectors.toList()));
		
		System.out.println(
				courses.stream()
					.map(course -> course.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.sorted()
					.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.flatMap(course -> dupCourses.stream().map(course2 -> List.of(course, course2)))
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.flatMap(course -> dupCourses.stream().map(course2 -> List.of(course, course2)))
				.filter(list -> list.get(0).equals(list.get(1)))
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.flatMap(course -> dupCourses.stream().map(course2 -> List.of(course, course2)))
				.filter(list -> list.get(0).length()==(list.get(1).length()))
				.collect(Collectors.toList()));
		
		// directly update the elements of the list
		// can't do this as we have created this collection using List.of()
//		courses.replaceAll(str -> str.toUpperCase());  
		
		List<String> modifiableCourses = new ArrayList(courses);
		
		modifiableCourses.replaceAll(str -> str.toUpperCase());
		System.out.println(modifiableCourses);
		
		modifiableCourses.removeIf(str -> str.length()<6);
		System.out.println(modifiableCourses);
	}
}
