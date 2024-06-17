package ch02.sec01;

public class VariableExchangeExample {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.println("x:" + x + ", y:" + y);

        // x = y라고 값을 대입하면 x와 y가 같은 값이 되기 때문에 swap 불가능
        // 임시값인 temp를 만들어서 x의 값을 담아둔다
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x + ", y:" + y);
    }
}
