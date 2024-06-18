package ch03.sec01;

public class IncreaseDecreaseOperatorExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z;

        x++; // 11
        ++x; // 12
        System.out.println("x=" + x);
        System.out.println("---------------------");

        y--; // 9
        --y; // 8
        System.out.println("y=" + y);
        System.out.println("---------------------");

        z = x++; // x값을 z에 넣고 x를 1 증가시킨다.
        System.out.println("z=" + z); // 12
        System.out.println("x=" + x); // 13
        System.out.println("---------------------");

        z = ++x; // x를 1증가시키고 x값을 z에 넣는다.
        System.out.println("z=" + z); // 14
        System.out.println("x=" + x); // 14
        System.out.println("---------------------");

        z= ++x + y++; // x를 1증가시키고 -> z = x+y -> y를 1증가
        System.out.println("z=" + z); // x: 15, y: 8 -> 23
        System.out.println("x=" + x); // 15
        System.out.println("y=" + y); // 9
    }
}
