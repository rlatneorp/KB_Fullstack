package add.abs;

public abstract class Computer {
    abstract void show();
    abstract void input();

    public void turnOn(){
        System.out.println("전원 켜기");
    }
    public void turnOff(){
        System.out.println("전원 끄기");
    }

}
