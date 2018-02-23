package com.viktorrahmanovic.nrt4912;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * Created by aca on 21/10/17.
 */

public class CheckboxQuestion extends Question {

    private String[] answers;
    private int[] selectedAnswers;

    public CheckboxQuestion(String questionText, String[] answers) {
        super(questionText);
        this.answers = answers;
    }


    public String[] getQuestions() {
        return answers;

    }

    public String getSelectedAnswersText() {

        String answersText= "";
        for (int i=0; i<selectedAnswers.length;i++) {
            if(selectedAnswers[i]>0) {
                answersText += answers[i] + " ";
            }
        }

        return answersText;
    }

    public void setSelectedAnswers(String[] selectedAnswers) {

        this.selectedAnswers = new int[selectedAnswers.length];
        for (int i = 0; i < answers.length; i++) {
            this.selectedAnswers[i]=0;
            for (String selectedAnswer : selectedAnswers) {
                if (Objects.equals(answers[i], selectedAnswer)) {
                    this.selectedAnswers[i] = 1;
                }
            }
        }
    }

}
