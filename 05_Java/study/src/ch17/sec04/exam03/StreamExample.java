package ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
    public static int sum;

    public static void main(String[] args){
        // range : 범위값 중 끝값을 포함하지 않는다
        // rangeClosed : 범위값 중 끝값을 포함한다.
        IntStream stream = IntStream.rangeClosed(1, 100);
        stream.forEach(a -> sum += a);
        System.out.println("총합: " + sum);
    }
}
