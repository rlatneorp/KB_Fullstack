package ch06.sec08.exam03;

public class Car {
    // 필드 선언
    int gas;

    // 리턴값이 없는 메소드로 매개값을 받아서 gas 필드값을 변경
    // set이 앞에 들어가는 메소드 : 값 변경, get이랑 같이 외워둘 것
    // 생성자와 하는 일은 같지만 생성자는 처음 한번만 호출된다.
    void setGas(int gas) {
        this.gas = gas;
    }
    // 리턴값이 boolean인 메소드로 gas 필드값이 0이면 false를, 0이 아니면 true를 리턴
    // 리턴하기전 조건에 따라 "gas가 없습니다" 또는 "gas가 있습니다" 출력
    // boolean 리턴하는 함수들은 대부분 앞에 is가 붙는다.
    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("gas가 없습니다.");
//            return을 만나면 함수 종료
            return false; // false를 리턴하고 메소드 종료
        }
        System.out.println("gas가 있습니다.");
        return true; // true를 리턴하고 메소드 종료
    }

    // 리턴값이 없는 메소드로 gas 필드값이 0이면 return 문으로 메소드를 종료
    void run() {
        while (true) {
            if (gas > 0) {
                System.out.println("달립니다.(gas잔량:" + gas + ")");
                gas -= 1;
            } else { // gas 가 0일때
                System.out.println("멈춥니다.(gas잔량:" + gas + ")");
                return; // break 대신 메소드 종료를 위한 return 사용
            }
        }
    }
}
