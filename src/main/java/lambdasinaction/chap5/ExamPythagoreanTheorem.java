package lambdasinaction.chap5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExamPythagoreanTheorem {

	public static void main(String[] args) {


		Stream<int[]> pythagoreanTriples = IntStream
			.rangeClosed(1,100).boxed()       // a 값 생성
			.flatMap(a ->
				IntStream
					.rangeClosed(1,100)       // b 값 생성
					.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0) // a*a + b*b = c*c 에서 c가 정수인 것만 filter
					.mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)})
			);

		pythagoreanTriples.forEach(t -> System.out.println(String.format("%d, %d, %d", t[0], t[1], t[2])));


		Stream<double[]> pythagoreanTriples2 = IntStream
				.rangeClosed(1, 100)  // a값 생성
				.boxed()              // IntStream -> Stream 변환
				.flatMap(a ->
					IntStream
					.rangeClosed(1, 100)  // b값 생성
					.mapToObj(b -> new double[]{a,b,Math.sqrt(a*a+b*b)}) // double[]{a,b,c} 생성
					.filter(t -> t[2] % 1 == 0) // c값이 정수인 것만 filter
				);

		pythagoreanTriples2.forEach(t -> System.out.println(String.format("%d, %d, %d", (int) t[0], (int) t[1],
				(int) t[2])));

	}

}
