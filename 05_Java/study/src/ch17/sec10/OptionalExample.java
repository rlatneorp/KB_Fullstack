package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // list가 비어있을 경우 예외 발생 (java.util.NoSuchElementException)
        /*double avg = list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .getAsDouble();
         */
        // 방법 1
//        기존 average의 리턴값인 OptionalDouble로 변수 생성
        OptionalDouble optional = list.stream()
                .mapToInt(Integer :: intValue)
                .average();
//        optional 값이 존재한다면 double로 변경해줌
        if (optional.isPresent()) {
            System.out.println("방법1_평균" + optional.getAsDouble());
        } else {
//        optional 값이 존재하지 않는 경우
            System.out.println("방법1_평균: 0.0");
        }

        // 해결방법 2

        double avg = list.stream()
                .mapToInt(Integer :: intValue)
                .average()
//                orElse : 해당 값이 존재하지 않는 경우 기본값을 정해준다
                .orElse(0.0);
        System.out.println("방법2_평균: " + avg);

        // 방법3
        list.stream()
                .mapToInt(Integer :: intValue)
                .average()
//                ifPresent: 만약 해당 값이 존재한다면 해당 기능을 실행
//                현재는 존재하지 않으므로 아무것도 출력되지 않음
                .ifPresent(a -> System.out.println("방법3_평균: " + a));
    }
}
