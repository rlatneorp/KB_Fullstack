package test;

import java.util.Scanner;

public class DatabaseExample {
    public static void main(String[] args) {
        System.out.println("MySQL에 연결합니다.");
        Scanner sc = new Scanner(System.in);
        System.out.print("데이터베이스: ");
        String mySql = sc.nextLine();
        if(mySql.equals("MySQL")) {
            System.out.println("MySQL을 닫습니다.");
        }
    }
}
