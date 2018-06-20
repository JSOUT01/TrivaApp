package com.example.jamessoutherland.trivaapp;

public class Question {

    private String Question;
    private String CorrectAnswer;
    private String WrongAnswerOne;
    private String WrongAnswerTwo;
    private String WrongAnswerThree;
    private String WrongAnswerFour;

    public String getQuestion() {
        return Question;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public String getWrongAnswerOne() {
        return WrongAnswerOne;
    }

    public String getWrongAnswerTwo() {
        return WrongAnswerTwo;
    }

    public String getWrongAnswerThree() {
        return WrongAnswerThree;
    }

    public String getWrongAnswerFour() {
        return WrongAnswerFour;
    }

    public Question(String question, String correctAnswer, String wrongAnswerOne, String wrongAnswerTwo, String wrongAnswerThree, String wrongAnswerFour) {
        Question = question;
        CorrectAnswer = correctAnswer;
        WrongAnswerOne = wrongAnswerOne;
        WrongAnswerTwo = wrongAnswerTwo;
        WrongAnswerThree = wrongAnswerThree;
        WrongAnswerFour = wrongAnswerFour;


    }
}
