package com.mcintosh.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int score = 0;
    public int harryCounter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Main part of the method that sums up score according to each
     * question's conditions
     * @param view
     */
    public void submit(View view) {
        EditText nameEntry = (EditText) findViewById(R.id.name_entry);
        String userName = nameEntry.getText().toString();

//        Question 1
        RadioButton question1 = (RadioButton) findViewById(R.id.question_one_f);
        boolean isOneChecked = question1.isChecked();
        if (isOneChecked) {
            score++;
        }
//        Question 2
        RadioButton question2 = (RadioButton) findViewById(R.id.question_two_c);
        boolean isTwoChecked = question2.isChecked();
        if (isTwoChecked) {
            score ++;
        }
//        Question 3
        RadioButton question3 = (RadioButton) findViewById(R.id.question_three_b);
        boolean isThreeChecked = question3.isChecked();
        if (isThreeChecked) {
            score ++;
        }
//        Question 4
        RadioButton question4 = (RadioButton) findViewById(R.id.question_four_a);
        boolean isFourChecked = question4.isChecked();
        if (isFourChecked) {
            score ++;
        }
//        Question 5
        CheckBox question5A = (CheckBox) findViewById(R.id.question_five_a);
        boolean isFiveA = question5A.isChecked();
        CheckBox question5B = (CheckBox) findViewById(R.id.question_five_b);
        boolean isFiveB = question5B.isChecked();
        CheckBox question5C = (CheckBox) findViewById(R.id.question_five_c);
        boolean isFiveC = question5C.isChecked();
        CheckBox question5D = (CheckBox) findViewById(R.id.question_five_d);
        boolean isFiveD = question5D.isChecked();

        if (isFiveA && isFiveB && !isFiveC && !isFiveD) {
            score++;
        }
//        Question 6
        if (harryCounter == 1) {
            score ++;
        }
//        Question 7
        RadioButton question7 = (RadioButton) findViewById(R.id.question_seven_d);
        boolean isSevenChecked = question7.isChecked();
        if (isSevenChecked) {
            score++;
        }

        displayScore(userName);

    }

    /**
     * increases Harry's horcrux kill count on click from question six
     * @param view
     */
    public void increment(View view) {
        harryCounter++;
        displayHarryCount(harryCounter);
    }

    /**
     * decreases Harry's horcrux kill count on click from question six
     * @param view
     */
    public void decrement(View view) {
        harryCounter--;
        displayHarryCount(harryCounter);
    }

    /**
     * This method changes the number for Harry's horcrux destruction counter for question six
     * @param number
     */
    private void displayHarryCount(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Takes the users name and displays the score screen
     * @param name
     */
    private void displayScore(String name) {
        TextView scoreMessage = (TextView) findViewById(R.id.score_view);
        String greeting;
        if (score == 7) {
            greeting = "Congratulations, ";
        }
        else if (score > 4) {
            greeting = "Great effort, ";
        }
        else if (score > 1) {
            greeting = "Bollocks, ";
        }
        else {
            greeting = "Oh, no ";
        }
        String message = greeting + name + "!\nYou got " + score +
        " out of 7 correct.";
        scoreMessage.setText(message);

        // reset score to zero
        score = 0;
    }
}
