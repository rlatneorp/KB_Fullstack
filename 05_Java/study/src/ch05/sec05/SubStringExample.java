package ch05.sec05;

public class SubStringExample {
    public static void main(String[] args) {
        String ssn = "880815-1234567";

//        String.subString(startIndex, endIndex) :
//        해당 문자열의 startIndex에서 endIndex -1까지 잘라낸다
        String firstNum = ssn.substring(0, 6);
        System.out.println(firstNum);

//        String.subString(startIndex) : 
//        해당 문자열의 startIndex부터 끝까지 잘라낸다
        String secondNum = ssn.substring(7);
        System.out.println(secondNum);
    }
}
