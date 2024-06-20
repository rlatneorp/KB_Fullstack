package add.abs;

public class ComExample {
    public static void main(String[] args) {
        Computer com = new DeskTop();
        com.show();
        com.turnOn();

        Notebook mac = new MacNotebook();
        mac.input();
    }
}
