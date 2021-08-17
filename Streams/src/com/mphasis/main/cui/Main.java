package com.mphasis.main.cui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*
Streams allows to process collection in an easier and faster way.
        numbers.parallelStream()
                .forEach(value -> System.out.println(Thread.currentThread()+String.valueOf(value)));
        System.out.println("------------------------------");
        numbers.stream()
                .forEach(value -> System.out.println(Thread.currentThread()+String.valueOf(value)));
        System.out.println("==============================");

        System.out.println(numbers.stream()
                .mapToInt(value -> value)       //mapToInt is similar to thenApply
                .sum());                         //thenAccept

        System.out.println(numbers.parallelStream()       //sum of even numbers
                .filter(value -> value%2==0)
                .mapToInt(value -> value)
                .sum());
*/
//        numbers.stream()
//                .map(String::valueOf)
//                .forEachOrdered(System.out::println);

//        String  result = numbers.stream()
////                .parallel()
////                .reduce(0,(total,element) -> Integer.sum(total, element));     //reduce is an aggregate operation
////                  .reduce(0, Integer::sum);
//                  .map(String::valueOf)
//                  .reduce("", (concatStr,element) -> concatStr.concat(element));
//        List<Integer> doubleOfEven; //= new ArrayList<Integer>();
//        doubleOfEven = numbers.stream()
//                .filter(element -> element%2==0)
//                .map(element -> element*2)
////                .forEach(element -> doubleOfEven.add(element));
//                .collect(Collectors.toList());
//         System.out.println(doubleOfEven);

        List<Person> people = createPeople();
//        Map<Integer,Person> result = people.stream()
//                .collect(Collectors.toMap(person -> person.getId(), person -> person));
//        System.out.println(result);

//        Map<Integer,List<Person>> result = people.stream()
//                .collect(Collectors.groupingBy(Person::getAge));  //Group by age
//        System.out.println(result);

        Map<Integer,List<String>> result = people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList())));  //Group by name, only return name
        System.out.println(result);

    }
    public static List<Person> createPeople(){
        return Arrays.asList(
                new Person(1,"Allen", 30),
                new Person(2,"Susan", 32),
                new Person(3,"Peter", 37),
                new Person(4,"Ravi", 30),
                new Person(5,"Geeta", 28),
                new Person(6,"Smith", 30)
        );
    }
}
