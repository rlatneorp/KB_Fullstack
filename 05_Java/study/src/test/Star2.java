package test;

public class Star {
    public static void main(String[] args) {
        String star = "★";
        String str = "";

        for(int i = 0; i < 5; i++){
            str += star;
            System.out.println(str);
        }
    }
}
