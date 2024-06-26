package ch11.sec02.exam02;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try{
//            forName : 해당 이름의 클래스를 찾아온다
            Class.forName("java.lang.String");
//            String 클래스는 존재하기 때문에 예외가 발생하지 않는다
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println();

        try{
            Class.forName("java.lang.String2");
//            String2 클래스는 존재하지 않기 때문에 예외가 발생하므로 아래 출력문은 실행되지 않고 catch문으로 넘어간다
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
