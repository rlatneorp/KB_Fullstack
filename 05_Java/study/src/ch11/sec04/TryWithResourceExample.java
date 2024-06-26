package ch11.sec04;

public class TryWithResourceExample {
    public static void main(String[] args) {
        try (MyResource res = new MyResource("A")){
            String data = res.read1();
            // read1로 "123"을 불러왔으므로 int 변환 잘 됨
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
        System.out.println();

        try (MyResource res = new MyResource("A")){
            String data = res.read2();
            // read2로 "abc"를 불러왔으므로 int 반환 시 NumberFormatException 발생
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            // try문 종료시 자동으로 close호출되고 에러 메시지 출력
            System.out.println("예외 처리: " + e.getMessage());
        }
        System.out.println();

        // 리소스 두개를 동시에 사용하는 2가지 방법
        /* try{
            MyResource res1 = new MyResource("A");
            MyResource res2 = new MyResource("A");
         ) {
            String data1 = res1.read1();
            String data2 = res2.read1();
            } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
         }*/

        MyResource res1 = new MyResource("A");
        MyResource res2 = new MyResource("B");
        try(res1; res2){ 
            String data1 = res1.read1();
            String data2 = res2.read1();
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
}
