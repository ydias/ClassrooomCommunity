package com.example.yann.classroom_community;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * User plays in this activity
 */
public class QuizActivity extends AppCompatActivity {
    TextView mScoreView;
    TextView mQuestionView;
    TextView mOpponent;
    TextView mPlayer;

    Button mButtonChoice1;
    Button mButtonChoice2;
    Button mButtonChoice3;
    Button mButtonChoice4;
    int mScore;
    int mQuestionNumber;
    String mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mPlayer = (TextView) findViewById(R.id.player);
        mOpponent = (TextView) findViewById(R.id.opponent);
        mPlayer.setText(getIntent().getExtras().getString("login"));
        mOpponent.setText(getIntent().getExtras().getString("OpponentName"));

        mScoreView = (TextView) findViewById(R.id.score);
         mQuestionView = (TextView) findViewById(R.id.question);
         mButtonChoice1 = (Button) findViewById(R.id.choice1);
         mButtonChoice2 = (Button) findViewById(R.id.choice2);
         mButtonChoice3 = (Button) findViewById(R.id.choice3);
         mButtonChoice4 = (Button) findViewById(R.id.choice4);

         // Get the first Question
        updateQuestion();


        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice1.getText()== mAnswer)
                {
                    mScore+=1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText()== mAnswer)
                {

                    mScore+=1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice3.getText()== mAnswer)
                {

                    mScore+=1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice4.getText()== mAnswer)
                {

                    mScore+=1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });

    }


    private void updateQuestion()
    {
        if(mQuestionNumber==4)
        {
            Intent intent = new Intent(this,MainActivity.class);
            getIntent().getExtras().putString("score",""+mScore);
            intent.putExtras(getIntent().getExtras());
            startActivity(intent);
        }
        else {
            mQuestionView.setText(Questions.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(Questions.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(Questions.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(Questions.getChoice3(mQuestionNumber));
            mButtonChoice4.setText(Questions.getChoice4(mQuestionNumber));
            mAnswer = Questions.getCorrectAnswer(mQuestionNumber);
            mScoreView.setText(mScore + "/4");
            mQuestionNumber++;
        }
    }
    private void updateScore(int point)
    {
        mScoreView.setText(mScore + "/4");
    }
}
