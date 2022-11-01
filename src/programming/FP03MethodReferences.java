package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
				"PCF", "Azure", "Docker", "Kubernetes");
		
		courses.stream()
//			.map(str -> str.toUpperCase())
			.map(String::toUpperCase) // will give the same result as above and getting called on the object of the specific string
			.forEach(System.out::println);
		
//		Supplier<String> supplier = () -> new String();
		Supplier<String> supplier = String::new; // constructor referencing
		
	}
}
