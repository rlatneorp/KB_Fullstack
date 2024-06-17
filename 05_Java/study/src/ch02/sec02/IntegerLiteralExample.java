package ch02.sec02;

public class IntegerLiteralExample {
    public static void main(String[] args) {
        int var1 = 0b1011; // 2진수 : 0B를 접두사로 붙인다
        int var2 = 0206; // 8진수 : 0을 접두사로 붙인다
        int var3 = 365; // 10진수 : 그냥 사용
        int var4 = 0xB3; // 16진수 : 0X를 접두사로 붙인다

        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);


    }
}
