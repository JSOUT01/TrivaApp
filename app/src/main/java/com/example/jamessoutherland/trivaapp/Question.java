package com.example.jamessoutherland.trivaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable{

    private String questionTitle;
    private String correctAnswer;
    private String firstWrongAnswer;
    private String secondWrongAnswer;
    private String thirdWrongAnswer;

    protected Question(String questionTitle, String correctAnswer, String firstWrongAnswer, String secondWrongAnswer, String thirdWrongAnswer) {
        this.questionTitle = questionTitle;
        this.correctAnswer = correctAnswer;
        this.firstWrongAnswer = firstWrongAnswer;
        this.secondWrongAnswer = secondWrongAnswer;
        this.thirdWrongAnswer = thirdWrongAnswer;
    }

    protected Question(Parcel in) {
        questionTitle = in.readString();
        correctAnswer = in.readString();
        firstWrongAnswer = in.readString();
        secondWrongAnswer = in.readString();
        thirdWrongAnswer = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(questionTitle);
        parcel.writeString(correctAnswer);
        parcel.writeString(firstWrongAnswer);
        parcel.writeString(secondWrongAnswer);
        parcel.writeString(thirdWrongAnswer);
    }
}
