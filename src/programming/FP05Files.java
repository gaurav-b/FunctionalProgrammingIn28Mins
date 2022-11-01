package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FP05Files {

	public static void main(String[] args) throws IOException {
		
		// to get the file text
		Files.lines(Paths.get("file.txt")).forEach(System.out::println);
		
		// to get unique words from the file text
		System.out.println(Files.lines(Paths.get("file.txt"))
				.map(str -> str.split(" "))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList()));
		
		
		Files.list(Paths.get("."))
		.filter(Files::isDirectory)
			.forEach(System.out::println);
	}

}
