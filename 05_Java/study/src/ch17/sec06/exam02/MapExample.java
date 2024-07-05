package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {
        int[] intArray = { 1, 2, 3, 4, 5 };

        IntStream array = Arrays.stream(intArray);
        array.asDoubleStream()
                .forEach(System.out::println);

        System.out.println();

        array = Arrays.stream(intArray);
        array.boxed()
                .forEach(System.out::println);
    }
}
