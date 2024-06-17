package ch02.sec02;

public class ByteExample {
    public static void main(String[] args) {
        byte var1 = -128;
        byte var2 = -20;
        byte var3 = 0;
        byte var4 = 30;
        byte var5 = 127;
//        byte var6 = 128 // byte의 유효범위가 -128부터 127까지이기 때문에 컴팡리 에러

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);
    }
}
