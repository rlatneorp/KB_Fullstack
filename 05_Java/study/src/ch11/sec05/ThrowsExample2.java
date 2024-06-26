package ch11.sec05;

public class ThrowsExample2 {
    // findClass에서 받아온 ClassNotFoundException을 상위 개념인 Exception으로 다시 던진다
    public static void main(String[] args) throws Exception {
        findClass();
    }
    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
