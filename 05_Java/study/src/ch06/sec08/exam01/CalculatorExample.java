package ch06.sec08.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();

        // 리턴 값이 없는 powerOn메서드 호출
        myCalc.powerOn();
        
        // return 값이 있는 경우만 따로 변수를 저장 가능
        int result1 = myCalc.plus(5, 6);
        System.out.println("result1: " + result1);


        int x = 10;
        int y = 4;
        double result2 = myCalc.divide(x, y);
        System.out.println("result2: " + result2);

        myCalc.powerOff();
    }
}
