package ch13.sec02.exam03;

public class GenericExample {
    public static void main(String[] args) {
        // Box를 사용할때 타입을 명시하지 않았기 때문에 Object로 간주된다
        Box box1 = new Box();
        // 해당 객체의 content 타입은 String이 된다
        box1.content = "100";
        
        Box box2 = new Box();
        box2.content = "100";
        
        Box box3 = new Box();
        // 해당 객체의 content 타입은 int가 된다
        box3.content = 100;

        // 해당 코드에서 box1이 해당 객체가 되고 box는 other가 된다
        // compare 사용시 box1의 content와 box2의 content가 같은지 비교
        boolean result1 = box1.compare(box2);
        System.out.println("result1: " + result1);

        boolean result2 = box1.compare(box3);
        System.out.println("result2: " + result2);
    }
}
