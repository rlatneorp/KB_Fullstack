package ch17.sec01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // Set 컬렉션 생성
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        // Stream을 이용한 요소 반복 처리 (set을 Stream으로 변환해서 저장)
        Stream<String> stream = set.stream();
        // Stream을 돌면서 요소를 name이란 이름으로 가져와서 출력
        stream.forEach( name -> System.out.println(name));
    }
}
