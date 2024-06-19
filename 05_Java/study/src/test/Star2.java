package test;

public class Star2 {
    public static void main(String[] args) {
        String star = "★";
        for(int i = 5; i > 0; i--){
            for(int j = 0; j < i; j++){
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
