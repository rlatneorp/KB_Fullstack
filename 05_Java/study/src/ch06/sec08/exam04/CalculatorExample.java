package ch06.sec08.exam04;

public class CalculatorExample {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();

        // 메서드 오버로딩 : 메서드 이름은 같지만 파라미터가 다르므로 각각 다른 메서드 호출
        // 정사각형 넓이 구하기
        double result1 = myCalc.areaRectangle(10);

        // 직사각형 넓이 구하기
        double result2 = myCalc.areaRectangle(10, 20);

        System.out.println("정사각형 넓이 = " + result1);
        System.out.println("직사각형 넓이 = " + result2);

    }
}
