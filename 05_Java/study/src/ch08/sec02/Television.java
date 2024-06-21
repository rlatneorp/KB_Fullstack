package ch08.sec02;

// 인터페이스 상속 시에는 implements 키워드 사용
public class Television implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }
}
