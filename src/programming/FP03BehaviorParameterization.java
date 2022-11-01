package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
//		filterAndPrint(numbers, x -> x%2==0);
//		filterAndPrint(numbers, x -> x%2!=0);
//		filterAndPrint(numbers, x -> x%3!=0);
		
		System.out.println(mapAAndCreateNewList(numbers, x -> x * x));
		System.out.println(mapAAndCreateNewList(numbers, x -> x * x * x));
		System.out.println(mapAAndCreateNewList(numbers, x -> x + x));
	}

	private static List<? super Integer> mapAAndCreateNewList(List<Integer> numbers, Function<? super Integer, ? super Integer> function) {
		return numbers.stream()
			.map(function)
			.collect(Collectors.toList());
		
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
			.filter(predicate)
			.forEach(System.out::println);
	}

}
