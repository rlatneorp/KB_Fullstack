package ch08.sec09;

public class ExtendsExample {
    public static void main(String[] args) {
        InterfaceCImpl impl = new InterfaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();
        // 인터페이스A에는 메서드B가 없기 때문에 사용 불가능
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        // 인터페이스 B에는 메서드A가 없기 때문에 사용 불가능
        System.out.println();

        // 인터페이스C에는 인터페이스A,B를 상속받고 있기 때문에 모두 사용 가능
        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
