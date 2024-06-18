package ch02.sec13;


import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
//        다음 칸에 입력받기 위해 print로 입력문 출력
        Scanner scanner = new Scanner(System.in);
//        스캐너로 한줄을 입력 받아서 strX에 저장
        System.out.print("x 값 입력: ");
        String strX = scanner.nextLine();
//        받아온 strX을 int로 형변환 (String -> int)
        int x = Integer.parseInt(strX);

//        스캐너로 한줄을 입력 받아서 strY에 저장
        System.out.print("y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);

        int result = x + y;
        System.out.println("x + y: " +  result);
        System.out.println();

        while(true) {
            System.out.print("입력 문자열: ");
            String data = scanner.nextLine();
            if(data.equals("q")) {
                break;
            }
            System.out.println("출력 문자열: " + data);
            System.out.println();
        }
        System.out.println("종료");
    }
}
