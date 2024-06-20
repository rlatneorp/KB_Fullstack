package add.abs;

public class DeskTop extends Computer{
    // 추상 메서드는 오버라이딩 필수, 나머지 일반 메서드는 오버라이딩 선택
    @Override
    void show() {
        System.out.println("데스크탑 화면 생성");
    }

    @Override
    void input() {
        System.out.println("데스크탑 입력 받기");
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }
}
