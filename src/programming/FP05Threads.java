package programming;

import java.util.stream.IntStream;

public class FP05Threads {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
		};

		Runnable runnable2 = () -> {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

		Thread thread2 = new Thread(runnable);
		thread2.start();

		Thread thread3 = new Thread(runnable);
		thread3.start();
		
		Thread thread4 
			= new Thread(
				() -> {
					IntStream.range(0, 10000)
						.forEach(
							i -> System.out.println(
									Thread.currentThread().getName() + ":" + i));
				}
			);
		thread4.start();
	}

}
