package com.viktorrahmanovic.nrt4912;

/**
 * Created by aca on 21/10/17.
 */

public class RadioQuestion extends Question {

    private String[] answers;
    private int selectedAnswer;



    public RadioQuestion(String questionText, String[] answers) {
        super(questionText);
        this.answers = answers;
    }
}
