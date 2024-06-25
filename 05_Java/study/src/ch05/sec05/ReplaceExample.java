package ch05.sec05;

public class ReplaceExample {
    public static void main(String[] args) {
        String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
        // String.replace(old, new) : 해당 문자열에서 old에 해당하는 값을 new로 변경한다
        String newStr = oldStr.replace("자바", "Java");

        System.out.println(oldStr);
        System.out.println(newStr);
    }
}
