package ch06.sec10.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
//        static 필드와 메서드는 클래스명으로 접근한다


//        이렇게도 쓸 수 있지만 굳이 안 쓴다
//        Calculator calc = new Calculator();

        double result1 = 10 * 10 * Calculator.pi;
        int result2 = Calculator.plus(10, 5);
        int result3 = Calculator.minus(10, 5);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
    }
}
