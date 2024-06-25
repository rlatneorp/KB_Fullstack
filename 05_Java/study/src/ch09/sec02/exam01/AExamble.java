package ch09.sec02.exam01;

public class AExamble {
    public static void main(String[] args) {
        // A 객체 생성
        A a = new A();
        // B 객체 생성
        // A 클래스 내에 있는 B클래스 타입이므로 A.B로 표시
        // 인스턴스 객체는 객체이름으로 접근해야 하기 때문에 a.new B()
        A.B b = a.new B();
    }
}
