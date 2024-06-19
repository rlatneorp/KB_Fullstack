package ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int)(Math.random()*20) + 81;
        System.out.println("점수: " + score);
        String grade;
        // 중첩 if문 : if문 안에 if문을 삽입해서 조건을 만들어줌
        if(score>=90) {
            if(score>=95) {
                grade = "A+";
            } else {
                grade = "A";
            }
        } else {
            if(score>=85) {
                grade = "B+";
            } else {
                grade = "B";
            }
        }
        System.out.println("학점: " + grade);
    }
}
