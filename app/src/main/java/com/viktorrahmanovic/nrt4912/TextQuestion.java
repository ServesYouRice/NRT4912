package com.viktorrahmanovic.nrt4912;


public class TextQuestion extends Question {

    private String answerText;

    public TextQuestion(String questionText) {
        super(questionText);
    }

    @Override
    public int getNoOfAnswers() {
        return 0;
    }

    @Override
    public int[] getSelectedAnswers() {
        return new int[0];
    }

    @Override
    public String[] getAnswers() {
        return new String[0];
    }

    @Override
    public Question copy() {
        return null;
    }

    public String getAnswerText() {
        return answerText;
    }


    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
