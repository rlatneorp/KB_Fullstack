package ch07.sec03.exam02;
// Phone 클래스의 자식 클래스
public class  SmartPhone extends Phone {
    public SmartPhone(String model, String color){
        // super키워드를 사용해서 받아온 model,color를 부모에게 넘겨줌
        // Phone(model, color); 와 동일한 기능
        super(model, color);

        System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
    }
}
