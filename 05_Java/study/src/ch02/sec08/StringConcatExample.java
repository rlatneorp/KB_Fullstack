package ch02.sec08;

public class StringConcatExample {
    public static void main(String[] args) {
        // 숫자 연산
        int result1 = 10 + 2 + 8;
        System.out.println("result1: " + result1);
        
        // 결합 연산
        // 숫자 두개가 앞에 나오면 숫자부터 계산한후 문자열 결합
        String result2 = 10 + 2 + "8";
        System.out.println("result2: " + result2);

        // 맨 앞 두개중 하나라도 문자열이면 그 후로는 문자열 결합
        String result3 = 10 + "2" + 8;
        System.out.println("result3: " + result3);

        String result4 = "10" + 2 + 8;
        System.out.println("result4: " + result4);

        // 괄호가 나오면 괄호부터 계산 후 문자열 결합
        String result5 = "10" + (2 + 8);
        System.out.println("result5: " + result5);
    }
}
