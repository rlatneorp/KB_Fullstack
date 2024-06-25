package cliFramework.command;

import cliFramework.domain.StudentScores;

public class PrintScoreCommand implements Command{
    StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void execute() {
        int [] scores = studentScores.getScores();
        for(int i=0; i<scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }
}