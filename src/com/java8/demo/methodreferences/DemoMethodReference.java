package com.java8.demo.methodreferences;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoMethodReference {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 12, 433, 5);

		// static metod refernce
		Optional<Integer> max = integers.stream().reduce(Math::max);

		// max.ifPresent(value -> System.out.println(value));

		//
		max.ifPresent(System.out::println);

		List<String> strings = Arrays.asList("kumar", "chanti", "shiva", "nagesh", "rajesh", "chinna", "kiran");

		// Method reference to instance method from class type
		// List<String> sorted = strings.stream().sorted((s1, s2) ->
		// s1.compareTo(s2)).collect(Collectors.toList());

		// System.out.println(sorted);

		// s1.compareTo(s2) is referred as String::compareTo
		List<String> sortedAlt = strings.stream().sorted(String::compareTo).collect(Collectors.toList());

		System.out.println(sortedAlt);

		
		//constructor reference
	//	List<Integer> numbers= IntStream.range(1, 100).boxed().collect(Collectors.toList());
		List<Integer> numbers= IntStream.range(1, 100).boxed().collect(Collectors.toCollection(ArrayList::new));

		Optional<Integer> maxnum = numbers.stream().reduce(Math::max);

		max.ifPresent(System.out::println);
	}
}
