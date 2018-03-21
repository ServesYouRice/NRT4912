package com.viktorrahmanovic.nrt4912;

import java.util.Objects;

/**
 * Created by aca on 21/10/17.
 */

public class RadioQuestion extends Question  {

    private String[] answers;
    private int selectedAnswer;



    public RadioQuestion(String questionText, String[] answers) {
        super(questionText);
        this.answers = answers;
    }

    public String[] getAnswers() {
        return answers;

    }

    public int[] getSelectedAnswers() {
        int[] selected = new int[answers.length];
        selected[selectedAnswer]=1;
        return selected;
    }

    public String getSelectedAnswerText() {
        return answers[selectedAnswer];


    }

    public void setSelectedAnswer(String selectedAnswer) {
        for(int i=0; i<answers.length; i++) {
            if(Objects.equals(answers[i], selectedAnswer)) {
                this.selectedAnswer = i;
            }
        }
    }

    @Override
    public Question copy() {
        return new RadioQuestion(getQuestionText(), answers);
    }

    @Override
    public int getNoOfAnswers() {
        return answers.length;
    }
}
