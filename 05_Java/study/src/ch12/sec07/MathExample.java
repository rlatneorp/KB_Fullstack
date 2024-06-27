package ch12.sec07;
public class MathExample{
    public static void main(String[] args) {
        // ceil : 해당 값을 올림 처리
        double v1 = Math.ceil(5.3);
        // floor : 해당 값을 내림 처리
        double v2 = Math.floor(5.3);
        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);

        // max : 둘중 큰 값을 반환
        long v3 = Math.max(3, 7);
        // min : 둘중 작은 값을 반환
        long v4 = Math.min(3, 7);
        System.out.println("v3=" + v3);
        System.out.println("v4=" + v4);

        double value = 12.3456;
        double temp1 = value * 100;
        // round : 해당 값을 반올림 처리
        long temp2 = Math.round(temp1);
        double v5 = temp2 / 100.0;
        System.out.println("v5=" + v5);
    }
}
