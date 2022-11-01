package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
//		Predicate<? super Integer> isEvenPredicate = x -> x%2==0;
		
		Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {
				return x%2 == 0;
			}
			
		};
		
//		Function<? super Integer, ? extends Integer> aquareFunction = x -> x*x;
		
		Function<Integer, Integer> aquareFunction = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
		};
			
//		Consumer<? super Integer> sysoutConsumer = System.out::println;
		
		Consumer<Integer> sysoutConsumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		};
		
		numbers.stream()
			.filter(isEvenPredicate)
			.map(aquareFunction)
			.forEach(sysoutConsumer);
		
//		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		
		BinaryOperator<Integer> sumBinaryOperator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		
		};
		
		int sum = numbers.stream()
					.reduce(0, sumBinaryOperator);
		
		System.out.println(sum);
		
		// Supplier
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		System.out.println(randomIntegerSupplier.get());
		
		// UnaryOperator
		UnaryOperator<Integer> unaryOperator = (x) -> 3*x;
		System.out.println(unaryOperator.apply(3));
		
		
		 BiPredicate<Integer, Integer> biPredicate = (x,y) -> x>y?true:false;
		 System.out.println(biPredicate.test(5, 4));
		 
		 BiFunction<Integer,Integer,String> biFunction = (x,y) -> x>y?"x is big":"y is big";
		 System.out.println(biFunction.apply(5, 4));
		 
		 BiConsumer<Integer, Integer> biConsumer = (x,y) -> System.out.println(x+y);
		 biConsumer.accept(5, 4);
		
		 // use below FIs when you are sure about the primitive type you are using
		 // we can do the similar things with the Consumer, Predicate or other FIs but then 
		 // we need to mention the data type we are working with, which leads us towards
		 // the autoboxing and unboxing process which will be the extra overhead for us
		 // so instead we can use these.
		 
		 // IntBinaryOperator
		 // IntConsumer
		 // IntFunction
		 // IntPredicate
		 // IntSupplier
		 // IntToDoubleFunction
		 // IntToLongFunction
		 // IntUnaryOperator
		
		 // Boolean, Long, Double, Float
		
	}

}
