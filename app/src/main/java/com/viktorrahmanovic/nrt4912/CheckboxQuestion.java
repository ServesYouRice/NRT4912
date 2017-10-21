package com.viktorrahmanovic.nrt4912;

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
}
