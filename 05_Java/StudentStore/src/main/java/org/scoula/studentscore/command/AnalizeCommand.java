package org.scoula.studentscore.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.studentscore.domain.StudentScores;

public class AnalizeCommand implements Command {
    StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void execute() {
        int [] scores = studentScores.getScores();
        int max = 0;
        int sum = 0;
        double avg = 0;
        for(int i=0; i < scores.length; i++) {
            max = (max<scores[i])? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentScores.getStudentNum();
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }
}