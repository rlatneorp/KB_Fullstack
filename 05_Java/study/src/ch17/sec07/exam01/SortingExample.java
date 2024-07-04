package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
//        comparable 인터페이스를 상속 받으면 compareTo를 무조건 구현해야한다
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("신용권", 10));
        studentList.add(new Student("유미선", 20));

        // 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted()
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();

        // 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
    }
}
