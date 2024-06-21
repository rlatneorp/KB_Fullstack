package cli.ui;

import cli.Input;

import java.util.Scanner;

public class Menu {
    private MenuItem[] list;

    public Menu(int size) {
        list = new MenuItem[size];
    }

    public void add(int ix, MenuItem item){
        list[ix] = item;
    }
    public void print(){
        for(int i = 0; i<list.length; i++){
//            System.out.print((i+1) + "] "+ list[i].getTitle());
            // 위의 코드와 동일
//            list를 돌면서 MenuItem을 하나씩 가져온다
//            해당 MenuItem의 인덱스+1과 메뉴 이름을 출력한다.
            System.out.printf("%d] %s", i+1, list[i].getTitle());
        }
    }
//        Input을 이용해 사용자로부터 메뉴를 선택
//        해당하는 MenuItem을 찾아 리턴
//        잘못된 선택이면 null 리턴

    public MenuItem select(){
        int i = Input.readInt("선택> ")-1;
        if(i < list.length){
//        제대로 i값을 입력 받았을 경우
            return list[i];
        }
//        i가 리스트의 길이보다 클 경우 null 반환
        return null;
    }
}
