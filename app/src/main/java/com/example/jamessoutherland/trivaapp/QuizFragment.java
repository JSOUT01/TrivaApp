package com.example.jamessoutherland.trivaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.jamessoutherland.trivaapp.MainActivity.QUESTIONS_LIST;

public class QuizFragment extends Fragment {

    @BindView(R.id.quiz_question_textview)
    protected TextView quizQuestion;

    @BindView(R.id.answer_one_button)
    protected Button answerOneButton;

    @BindView(R.id.answer_two_button)
    protected Button answerTwoButton;

    @BindView(R.id.answer_three_button)
    protected Button answerThreeButton;

    @BindView(R.id.answer_four_button)
    protected Button answerFourButton;

    private List<Question> questionsList;
    private Question question;
    private int questionListPosition = 0;
    private int correctAnswers = 0;
    private QuizCallback quizCallback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public static QuizFragment newInstance() {

        Bundle args = new Bundle();

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();

        questionsList = getArguments().getParcelableArrayList(QUESTIONS_LIST);

        populateQuizContent();
    }

    private void populateQuizContent() {
        question = questionsList.get(questionListPosition);
        quizQuestion.setText(question.getQuestionTitle());


        List<Button> buttonList = new ArrayList<>();
        buttonList.add(answerOneButton);
        buttonList.add(answerTwoButton);
        buttonList.add(answerThreeButton);
        buttonList.add(answerFourButton);

        //Just like with buttons, this arrayList will take all of the possible answers and allow us to access them.
        List<String> possibleAnswersList = new ArrayList<>();
        possibleAnswersList.add(question.getCorrectAnswer());
        possibleAnswersList.add(question.getFirstWrongAnswer());
        possibleAnswersList.add(question.getSecondWrongAnswer());
        possibleAnswersList.add(question.getThirdWrongAnswer());

        //This For Each loop takes the arrayLists we made and actually allows us to randomize what question goes on which button.
        for (Button button : buttonList) {
            int random = (int) Math.ceil(Math.random() * (possibleAnswersList.size() - 1));
//Using the random number above we will set the text of the button by getting that item from the possible answer list.
            button.setText(possibleAnswersList.get(random));
            //To make sure we don't use the same answer twice we remove the possible answer from the list
            possibleAnswersList.remove(random);
        }

    }

    private void checkAnswer(String answer){
        disableAnswerButtons();
        //Increments questionListPosition so we can go to the next question.

        questionListPosition++;
        if(question.getCorrectAnswer().equals(answer)) {
            //Sets the textView to show the user that they were correct.
            quizQuestion.setText(R.string.correct_answer_text);
            //Increments the correct answers the user has gotten.
            correctAnswers++;
        }else {
            quizQuestion.setText(getString(R.string.wrong_answer_text, question.getCorrectAnswer()));

        }

    }

    @OnClick(R.id.answer_one_button)
    protected void buttonOneClicked() {

checkAnswer(answerOneButton.getText().toString());
    }
    @OnClick(R.id.answer_two_button)
    protected void buttonTwoClicked() {
        checkAnswer(answerTwoButton.getText().toString());

    }
    @OnClick(R.id.answer_three_button)
    protected void buttonThreeClicked() {
        checkAnswer(answerThreeButton.getText().toString());

    }
    @OnClick(R.id.answer_four_button)
    protected void buttonFourClicked() {
        checkAnswer(answerFourButton.getText().toString());

    }
    @OnClick(R.id.quiz_next)
    protected void nextButtonClicked() {

        enableAnswerButtons();

        if(questionListPosition <= questionsList.size() -1) {
            populateQuizContent();
        }else {
            //handling no more questions, taking user back to MainActivity
           quizCallback.quizFinished(correctAnswers);
        }
    }

    private void disableAnswerButtons() {
        answerOneButton.setEnabled(false);
        answerTwoButton.setEnabled(false);
        answerThreeButton.setEnabled(false);
        answerFourButton.setEnabled(false);
    }

    private void enableAnswerButtons() {
        answerOneButton.setEnabled(true);
        answerTwoButton.setEnabled(true);
        answerThreeButton.setEnabled(true);
        answerFourButton.setEnabled(true);

    }

    public void attachParent (QuizCallback quizCallback) {
        this.quizCallback = quizCallback;
    }

    public interface QuizCallback {

        void quizFinished(int correctAnswers);
    }

}
