package com.viktorrahmanovic.nrt4912;

/**
 * Created by aca on 21/10/17.
 */

public class TextQuestion extends Question {

    private String answerText;

    public TextQuestion(String questionText) {
        super(questionText);
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
