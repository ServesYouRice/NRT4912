package com.viktorrahmanovic.nrt4912;

public abstract class Question {

    private String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    abstract public int getNoOfAnswers();
    abstract public int[] getSelectedAnswers();
    abstract public String[] getAnswers();
    abstract public Question copy();

}
