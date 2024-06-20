package ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        int r = 10;

        Calculator calculator = new Calculator();
//        Calculator 클래스의 areaCircle 호출
        System.out.println("원 면적: " + calculator.areaCircle(r));
        System.out.println();
//        Computer 클래스의 areaCircle 호출
        Computer computer = new Computer();
        System.out.println("원 면적: " + computer.areaCircle(r));
    }
}
