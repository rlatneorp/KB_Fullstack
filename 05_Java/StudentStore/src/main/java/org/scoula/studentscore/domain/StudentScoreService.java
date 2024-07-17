package org.scoula.studentscore.domain;

import org.scoula.lib.cli.ui.Input;

public class StudentScoreService {
    StudentScores studentScores = StudentScores.getInstance();

    public void initScores() {
        StudentScores studentScores = StudentScores.getInstance();
        int studentNum = Input.getInt("학생수> ");
        studentScores.setStudentNum(studentNum);
    }

    public void getScores() {
        StudentScores studentScores = StudentScores.getInstance();
        int [] scores = studentScores.getScores();
        for(int i = 0; i< scores.length; i++) {
            scores[i] = Input.getInt("scores[" + i + "]> ");
        }
    }

    public void printScores() {
        StudentScores studentScores = StudentScores.getInstance();
        int [] scores = studentScores.getScores();
        for(int i=0; i<scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }

    public void analize() {
        StudentScores studentScores = StudentScores.getInstance();
        int [] scores = studentScores.getScores();
        int max = 0;
        int sum = 0;
        double avg = 0;
        for(int i=0; i<scores.length; i++) {
            max = (max<scores[i])? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentScores.getStudentNum();
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }
}