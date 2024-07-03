package ch16.sec01;

public class LambdaExample {
    public static void main(String[] args) {
//        action 내의 람다함수가 실제로는 Calculable내에 있는 calculate 함수를 의미한다
        action((x, y) -> {
           int result = x + y;
           System.out.println("result: " + result);
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }

    public static void action(Calculable calculable) {
        // 데이터
        int x = 10;
        int y = 4;
        // 데이터 처리
        // 해당 부분에 제공되는 함수 역할이 람다식이다.
        calculable.calculate(x, y);
    }

}
