package ch11.sec06;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();
        // 예금하기
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        // 출금하기
        try{
            account.withdraw(30000);
        } catch(InsufficientException e) {
//      InsufficientException 생성자에서 문자열을 저장해두고 getMessage로 가져오기
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}

