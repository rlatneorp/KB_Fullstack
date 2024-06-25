package ch05.sec05;

public class EmptyStringExample {
    public static void main(String[] args) {
        String hobby = "";
        
        // 빈 문자열 확인시 자주 확인하는 방법
        if(hobby.equals("")){
            System.out.println("hobby 변수가 참조하는 String 객체는 빈 문자열");
        }
    }
}
