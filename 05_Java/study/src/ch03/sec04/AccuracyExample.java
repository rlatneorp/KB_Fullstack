package ch03.sec04;

public class AccuracyExample {
    public static void main(String[] args) {
        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;

//        부동소수점의 경우 이진수의 한계로 정확한 계산이 어렵다
        double result = apple - number * pieceUnit;
        System.out.println("사과 1개에서 남은 양: " + result);
    }
}
