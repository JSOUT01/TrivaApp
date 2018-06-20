package com.example.jamessoutherland.trivaapp;

public class Question {

    private String questionTitle;
    private String correctAnswer;
    private String firstWrongAnswer;
    private String secondWrongAnswer;
    private String thirdWrongAnswer;

    public Question(String questionTitle, String correctAnswer, String firstWrongAnswer, String secondWrongAnswer, String thirdWrongAnswer) {
        this.questionTitle = questionTitle;
        this.correctAnswer = correctAnswer;
        this.firstWrongAnswer = firstWrongAnswer;
        this.secondWrongAnswer = secondWrongAnswer;
        this.thirdWrongAnswer = thirdWrongAnswer;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getFirstWrongAnswer() {
        return firstWrongAnswer;
    }

    public void setFirstWrongAnswer(String firstWrongAnswer) {
        this.firstWrongAnswer = firstWrongAnswer;
    }

    public String getSecondWrongAnswer() {
        return secondWrongAnswer;
    }

    public void setSecondWrongAnswer(String secondWrongAnswer) {
        this.secondWrongAnswer = secondWrongAnswer;
    }

    public String getThirdWrongAnswer() {
        return thirdWrongAnswer;
    }

    public void setThirdWrongAnswer(String thirdWrongAnswer) {
        this.thirdWrongAnswer = thirdWrongAnswer;
    }
}
