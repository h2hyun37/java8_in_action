package lambdasinaction.chap5;

import java.util.stream.Stream;

public class FibbonacciUsingFP {

	public static void main(String[] args) {

		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(20)
				.forEach(t -> System.out.printf("%d, ", t[1]));

	}

}
