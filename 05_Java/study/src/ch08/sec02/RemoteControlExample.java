package ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;

        // rc변수에 Television 객체를 대입
        rc = new Television();
        rc.turnOn();

        // rc변수에 Audio 객체를 대입( 교체)
        rc = new Audio();
        rc.turnOn();
    }
}
