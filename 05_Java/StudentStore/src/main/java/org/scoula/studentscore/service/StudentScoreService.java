package org.scoula.studentscore.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.studentscore.domain.StudentScores;

public class StudentScoreService {
    StudentScores studentScores = StudentScores.getInstance();

//    메뉴1. 학생수 입력
    public void initScores() {
        int studentNum = Input.getInt("학생수> ");
        studentScores.setStudentNum(studentNum);
    }

//    메뉴2. 점수 입력
    public void getScores() {
        int [] scores = studentScores.getScores();
        for(int i = 0; i< scores.length; i++) {
            scores[i] = Input.getInt("scores[" + i + "]> ");
        }
    }

//    메뉴3.점수 출력
    public void printScores() {
        int [] scores = studentScores.getScores();
        for(int i=0; i<scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }

//    메뉴4. 분석 출력
    public void analize() {
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