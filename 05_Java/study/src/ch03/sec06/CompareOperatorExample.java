package ch03.sec06;

public class CompareOperatorExample {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);
        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);

        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = (char1 < char2); // A의 아스키코드값 65보다 B의 아스키코드값 66이 큰가 묻는 것
        System.out.println("result4 : " + result4);

        int num3 = 1;
        double num4 = 1.0;
        boolean result5 = (num3 == num4); // double로 변경돼서 둘 다 같다고 나옴
        System.out.println("result5 : " + result5);

        float num5 = 0.1f;
        double num6 = 0.1;
        boolean result6 = (num5 == num6); // false
        boolean result7 = (num5 == (float)num6); // true
        System.out.println("result6 : " + result6);
        System.out.println("result7 : " + result7);

        String str1 = "자바";
        String str2 = "Java";
        boolean result8 = (str1.equals(str2)); // String끼리 비교할 때는 equals()
        boolean result9 = (!str1.equals(str2)); // 나온 결과값을 반대로 뒤집을 때는 !를 맨 앞에 붙여준다
        System.out.println("result8 : " + result8);
        System.out.println("result9 : " + result9);
    }
}
