package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data){
       // 받아 온 data값의 길이를 result에 할당
        int result = data.length();
        // data가 null일 경우 NullPointerException 발생
        System.out.println("문자 수 : " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava"); // 위쪽에 있는 printLength 메서드 호출
        printLength(null); // null을 대입했으므로 해당 부분에서 Exception 발생
        System.out.println("[프로그램 종료]"); // 위쪽에서 예외 발생으로 해당 부분 출력 안됨
    }
}
