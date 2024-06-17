package ch02.sec01;

public class VariableUseExample{
    public static void main(String[] args) {
        int hour = 3;
        int minute = 5;
        // 문자와 변수를 이어줄 때는 +로 이어준다
        // 문자열은 "를 정해주고, 변수는 변수 이름만 작성
        System.out.println(hour + "시간 " + minute + "분" ) ;

        int totalMinute = (hour * 60) + minute;
        System.out.println("총 " + totalMinute + "분");
    }
}
