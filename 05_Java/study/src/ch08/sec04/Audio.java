package ch08.sec04;

public class Audio implements RemoteControl{

    private int volume;


    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다");
    }

    @Override
    public void setVolume(int volume) {
        // 최대값 10, 최소값 0을 벗어나면 벗어나지 않게 위의 if문에서 처리해줌
        // 범위 내의 값이 제대로 들어가면 voluume에 반영
        if( volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if (volume < RemoteControl.MIN_VOLUME){
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 Audio 볼륨: " + volume);
    }
}
