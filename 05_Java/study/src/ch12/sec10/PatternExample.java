package ch12.sec10;

import java.util.regex.Pattern;

public class PatternExample {
    public static void main(String[] args) {
        // (02|010) : 02나 010 인지
        // d{3,4} : digit(숫자값)가 3개나 4개인지
        // \d{4} : digit가 정확히 4개인지
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-123-4567";
//        Pattern.matches : 정규 표현식으로 문자열을 검증해준다
        boolean result = Pattern.matches(regExp, data);
        if (result) {
            System.out.println("정규식과 일치합니다.");
        } else {
            System.out.println("정규식과 일치하지 않습니다");
        }

        // \\w : word(문자-영어대소문자, 숫자포함)가 1개 이상인지
        // \\.\\w+ : .뒤에 word가 1개이상 나오는지
        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "angel@mycompanaycom";
        result = Pattern.matches(regExp, data);
        if (result) {
            System.out.println("정규식과 일치합니다.");
        } else {
            System.out.println("정규식과 일치하지 않습니다");
        }
    }
}
