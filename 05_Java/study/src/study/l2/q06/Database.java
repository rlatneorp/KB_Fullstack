package study.l2.q06;

class Database {

    private static String connection = "MySQL";

    private static Database singleton = new Database();

    private Database() { }

    public static Database getInstance() {
        return singleton;
    }

    public void connect() {
        System.out.println(connection + "에 연결합니다.");
    }

    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }
}
