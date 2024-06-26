package ch12.sec03.exam02;

public class HashCodeExample {
    public static void main(String[] args) {
        Student s1 = new Student(1, "홍길동");
        Student s2 = new Student(1, "홍길동");

//        "홍길동"의 메모리주소와 no가 모두 같기 때문에 hashCode()에서도 동일한 값을 리턴한다.
        if(s1.hashCode() == s2.hashCode()) {
//            equals 내부에서 타입, no, name 세개가 같은지 체크
            if(s1.equals(s2)) {
                System.out.println("동등 객체입니다.");
            }else{
                System.out.println("데이터가 다르므로 동등 객체가 아닙니다.");
            }
        }else {
            System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
        }
    }
}
