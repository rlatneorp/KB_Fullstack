package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        // 선택번호
        int[] selectNumber = new int[6];
        Random random = new Random(3);
        System.out.print("선택번호: ");
        for(int i = 0; i < 6; i++) {
            // 0 ~ 44까지를 랜덤으로 생성한후 어떤 숫자가 나오든 1을 더해준다
            // 따라서 1~45까지의 랜덤숫자가 된다
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.print(selectNumber[i] + " ");
        }
        System.out.println();

        // 당첨번호
        int[] winningNumber = new int[6];
        random = new Random(5);
        System.out.print("당첨번호: ");
        for(int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.print(winningNumber[i] + " ");
        }
        System.out.println();

        // 당첨여부, 비교하기 전에 배열 항목을 정렬
        // Arrays.sort() : 해당 배열을 오름차순으로 정렬해준다
        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);
        // Arrays.equals() : 두개의 배열값이 같은지 비교
        boolean result = Arrays.equals(selectNumber, winningNumber); // 배열 항목 비교
        System.out.print("당첨여부: ");
        if(result) {
            System.out.println("1등에 당첨되셨습니다.");
        } else {
            System.out.println("당첨되지 않았습니다.");
        }
    }
}
