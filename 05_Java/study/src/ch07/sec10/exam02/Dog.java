package ch07.sec10.exam02;

public class Dog extends Animal {
    // 추상 메서드는 자식 클래스에서 무조건 재정의를 해줘야한다.
    // 부모 클래스에 구현부가 없기 때문에
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
