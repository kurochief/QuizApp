package com.example.android.quizapp;


import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Those are my variables:

    public static int result = 0;
    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    //Here I need to declare the right answers by calling them by ID.

    private int answers()

    {
        RadioButton answerOne = findViewById(R.id.radio_air);
        RadioButton answerTwo = findViewById(R.id.radio_2012);
        RadioButton answerThree = findViewById(R.id.radio_CGO2);
        RadioButton answerFour = findViewById(R.id.radio_your_startup);
        CheckBox firstAnswerFive = findViewById(R.id.spotify_checkbox);
        CheckBox secondAnswerFive = findViewById(R.id.whatsapp_checkbox);
        CheckBox firstChoiceFive = findViewById(R.id.microsoft_checkbox);
        CheckBox secondChoiceFive = findViewById(R.id.apple_checkbox);

        //In this Quiz I just need to check the correct answers in order to calculate the total score.
        //Negative answers do not decrease the score.
        //"result" variable starts from 0 (defined at line 19 of the code).

        if (answerOne.isChecked()) {
            result = result + 1;
        }

        if (answerTwo.isChecked()) {
            result = result + 1;
        }

        if (answerThree.isChecked()) {
            result = result + 1;
        }

        if (answerFour.isChecked()) {
            result = result + 1;
        }


        if ((firstAnswerFive.isChecked() && secondAnswerFive.isChecked()) && (!firstChoiceFive.isChecked()) && (!secondChoiceFive.isChecked())) {
            result = result + 1;
        }

        return result;
    }

    /**
     * This method is called when the "Check your answer" button is clicked.
     */

    public void summitAnswers(View view) {
        int finalResult = answers();

        EditText nameEditText = findViewById(R.id.your_name);
        name = nameEditText.getText().toString();

        //Toast message
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter you name :)", Toast.LENGTH_SHORT).show();
        } else {
            TextView quantityTextView = (TextView) findViewById(R.id.score_text_view);
            quantityTextView.setText(name + ": " + result + " out of 5!");
        }
    }

    /**
     * This method is called when the "Try again" button is clicked.
     */

    public void resetScore(View view) {
        TextView resultText = findViewById(R.id.score_text_view);

        name = " ";
        result = 0;
        resultText.setText(" ");


    }

}