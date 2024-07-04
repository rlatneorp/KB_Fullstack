package ch17.sec10;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class AggregateExample {
    public static void main(String[] args) {
        // 정수 배열
        int[] arr = {1, 2, 3, 4, 5};

        //카운팅
        // count : 요소들의 개수를 long으로 반환
        long count = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        //총합
        // sum : 요소들의 총합을 long으로 반환
        long sum = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);

        // 평균
        // average : 요소들의 평균을 OptionalDouble로 반환함. double로 변경해줘야함
        double avg = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        //최대값
        // max : 요소 중 최대값을 OptionalInt로 반환, int로 변경 필요
        int max = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        //최소값
        // min : 요소 중 최소값을 OptionalInt로 반환, int로 변경 필요
        int min = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .min()
                .getAsInt();
        System.out.println("최소값: " + min);

        //첫 번째 요소
        // findFirst : 해당하는 요소들의 첫번 째 값을 OptionalInt로 반환, int로 변경 필요
        int first = Arrays.stream(arr)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);
    }
}
