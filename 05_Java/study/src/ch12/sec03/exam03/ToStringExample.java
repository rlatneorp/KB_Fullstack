package ch12.sec03.exam03;

public class ToStringExample {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("삼성전자", "안드로이드");

//        toString 메서드 호출 시 기본값은 주소값이지만 원하는 값이 출력되도록 오버라이딩할 수 있다
        String srtObj = myPhone.toString();
        System.out.println(srtObj);

        System.out.println(myPhone);
    }
}
