package ch09.sec05.exam02;

public class A {
    // A 인스턴스 필드
    String field = "A-field";
    //인스턴스 메서드
    void method(){
        System.out.println("A-method");
    }

    // 인스턴스 멤버 클래스
    class B {
        //B 인스턴스 필드
        String field = "B-field";
        void method(){
            System.out.println("B-method");
        }

        void print(){
            System.out.println(this.field);
            this.method();

            System.out.println(A.this.field);
            A.this.method();
        }

        void useB(){
            B  b = new B();
            b.print();
        }
    }

}
