package ch11.sec04;

public class MyResource implements AutoCloseable{
    private String name;
    public MyResource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }
    public String read1() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "100";
    }
    public String read2() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "abc";
    }
    // 해당 메서드는 리소스를 다 사용했을때 자동으로 호출된다
    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + name + ") 닫기]");
    }
}
