package lambdasinaction.chap5;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * exam : 5장 스트림 활용 : 5.5 실전연습
 *
 * @author 1001065
 *
 */
public class ExerciseChap5 {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Biran", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
);

		// exam 1 : 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오
		List<Integer> exam1 = transactions.stream().filter(p -> p.getYear() == 2011).map(p -> p.getValue()).sorted()
				.collect(Collectors.toList());

		System.out.println(exam1);

		System.out.println("=================================");

		// exam 2 : 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
		transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
				.forEach(p -> System.out.println(p));

		System.out.println("=================================");

		// exam 3 : 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
		List<Trader> exam3 = transactions.stream()
					.filter(transaction -> "cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
					.map(transaction -> transaction.getTrader())
					.distinct()
					.sorted(comparing(Trader::getName))
					.collect(Collectors.toList());

		System.out.println(exam3);

		System.out.println("=================================");

		// exam 4 : 모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하시오
		String exam4 = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted()
				.collect(Collectors.joining());

		System.out.println(exam4);

		System.out.println("=================================");

		// exam 5 : 밀라노 Milan 에 거래자가 있는가 ?
		boolean exam5 = transactions.stream().anyMatch(
				transaction -> "milan".equalsIgnoreCase(transaction.getTrader().getCity()));

		System.out.println(exam5);
		System.out.println("=================================");


		// exam 6 : 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
		transactions.stream().filter(transaction -> "cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
				.map(Transaction::getValue).forEach(System.out::println);

		System.out.println("=================================");

		// exam 7 : 전체 트랜잭션 중 최댓값은 얼마인가?
		OptionalInt exam7 = transactions.stream().mapToInt(transaction -> transaction.getValue()).max();

		System.out.println(exam7.getAsInt());

		System.out.println("=================================");

		// exam 8 : 전체 트랜잭션 중 최솟값은 얼마인가?
		OptionalInt exam8 = transactions.stream().mapToInt(Transaction::getValue).min();
		System.out.println(exam8);

	}

}

