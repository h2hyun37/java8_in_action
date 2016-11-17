package lambdasinaction.chap4;

import static java.util.stream.Collectors.toList;
import static lambdasinaction.chap4.Dish.menu;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LazyEvaluationExam {

	public static void main(String[] args) {


		Predicate<Dish> predicate = d -> {System.out.println("filtering : " + d.getName()); return d.getCalories() > 530;};

		Function<Dish, String> mapper = d -> {System.out.println("mapping : " + d.getName()); return d.getName();};

		Function<Dish, Dish> action = d -> {
			System.out.println("mapping(2) : " + d.getName());
			return d;
		};

		List<String> names = menu.stream()
				.map(action)
				.filter(predicate)
.map(mapper)
.limit(3)
				.collect(toList());


		System.out.println(names);





	}

}
