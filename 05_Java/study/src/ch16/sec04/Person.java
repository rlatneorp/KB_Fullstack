package ch16.sec04;

public class Person {
    public void action(Calcuable calcuable){
        // calc 함수는 매개변수가 2개고 return 값이 double인 함수 예측 가능
        double result = calcuable.calc(10,4);
        System.out.println("결과: " + result);
    }
}
