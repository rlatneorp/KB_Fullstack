package ch17.sec03;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        // 방법1
        Stream<Student> studentStream = list.stream();
        // 중간 처리(학생 객체를 점수로 매핑 후 int 처리)
        IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
        // 최종 처리(평균 점수를 구한 후 double 처리)
        double avg = scoreStream.average().getAsDouble();
        System.out.println("평균 점수: " + avg);

        // 방법 2
        // 메소드 체이닝을 이용해서 위의 코드를 이어줌
        double avg2 = list.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();
        System.out.println("평균 점수 :" + avg2);
    }


}
