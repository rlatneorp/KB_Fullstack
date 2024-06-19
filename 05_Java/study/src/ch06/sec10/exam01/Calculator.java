package ch06.sec10.exam01;

public class Calculator {
    // static을 붙였으므로 정적 필드
    static double pi = 3.14159;

    // static을 붙였으므로 정적 메소드
    static int plus(int x, int y){
        return x + y;
    }

    static int minus(int x, int y){
        return x - y;
    }
}
