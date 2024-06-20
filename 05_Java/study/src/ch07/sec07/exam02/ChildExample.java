package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        //  자식 객체 생성
        Child child = new Child();
        
        // 자동 타입 변환
        Parent parent = new Child();
        
        // 메소드 호출
        parent.method1();
        parent.method2();
        // 부모 타입은 자식 타입으로 자동 변환되지 않기 때문에 컴파일 에러
//        parent.method3();
    }
}
