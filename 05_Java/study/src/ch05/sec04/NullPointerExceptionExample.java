package ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        // null인 배열에 0번째 값을 할당했기 때문에 NullPointerException 발생
        int[] intArray = null;
        // intArray[o] = 10; // NullPointerException

        String str = null;
        // null로 초기화된 문자열의 길이를 출력했기 때문에 NullPointerException 발생
        System.out.println("총 문자 수 : " + str.length() ); // NullPointerException
    }
}
