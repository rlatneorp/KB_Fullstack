package ch12.sec03.exam02;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        Student s1 = new Student(1, "홍길동");
//        set은 아이템 추가시 죽복된 아이템은 제외시킨다
//        hashcode를 호출해서 같은 값이 리턴되면 같은 객체라고 판단한다
        hashSet.add(s1);
        System.out.println("저장된 객체 수: " + hashSet.size());

        Student s2 = new Student(1, "홍길동");
//        s1과 s2의 no와 name이 모두 같으므로 hashCode 내에서도 같은 값을 반환한다
//        따라서 같은 객체로 인식되기 때문에 add를 해도 set내에 추가되지 않는다
//        hashCode를 오버라이딩한 코드를 주석 처리하면 기본적으로 주소를 비교하기 때문에 다 다른 객체로 인식된다
        hashSet.add(s2);
        System.out.println("저장된 객체 수: " + hashSet.size());

        Student s3 = new Student(2, "홍길동");
        hashSet.add(s3);
        System.out.println("저장된 객체 수: " + hashSet.size());
    }
}

