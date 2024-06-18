package ch03.sec07;

public class LogicalOperatorExample {
    public static void main(String[] args) {
        int charCode = 'A';
//        int charCode = 'a';
//        int charCode = '5';

        // && : 앞과 뒤의 조건이 모두 true인 경우에만 true 반환(AND)
        if((65 <= charCode) & (charCode <= 90)){
            System.out.println("대문자이군요.");
        }
        if((97 <= charCode) && (charCode <= 122)){
            System.out.println("소문자이군요.");
        }
        if((48 <= charCode) && (charCode <= 57)){
            System.out.println("0~9 숫자이군요.");
        }

        int value = 6;
//       int value = 7;

        // || : 앞과 뒤의 조건 중 하나만 true여도 true반환 (OR)
        // 6이 2의 배수거나 6이 3의 배수인 경우
        if((value % 2 == 0) | (value % 3 == 0)){
            System.out.println("2 또는 3의 배수이군요");
        }

        boolean result = (value % 2 == 0) || (value % 3 == 0);
        // ! : 결과값의 반대 (reuslt가 true기 때문에 !를 붙이면 false가 된다
        if(!result){
            System.out.println("2 또는 3의 배수가 아니군요.");
        }
    }
}
