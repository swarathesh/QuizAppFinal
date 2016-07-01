package com.salyert.swarathesh.quizappproj3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button odd, even;
    private TextView score,displayScore;
    public int count=0,OddOrEven=0;

    public int getOddOrEven() {
        return OddOrEven;
    }

    public void setOddOrEven(int oddOrEven) {
        OddOrEven = oddOrEven;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //generate();
        odd = (Button) findViewById(R.id.odd);
        even = (Button) findViewById(R.id.even);
        score = (TextView) findViewById(R.id.score);
        displayScore = (TextView) findViewById(R.id.updateScore);
        odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( getOddOrEven() % 2 != 0){
                    Toast.makeText(getApplicationContext(),"CORRECT",Toast.LENGTH_LONG).show();
                    count+=1;
                    DisplayScoreodd(count);


                }
                else {
                    Toast.makeText(getApplicationContext(),"WRONG",Toast.LENGTH_LONG).show();
                    count-=1;
                    DisplayScore(count);

                }

            }
        });


        even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( getOddOrEven() % 2 == 0){
                    Toast.makeText(getApplicationContext(),"CORRECT",Toast.LENGTH_LONG).show();
                    count+=1;
                    DisplayScore(count);

                }
                else {
                    Toast.makeText(getApplicationContext(),"WRONG",Toast.LENGTH_LONG).show();
                    count-=1;
                    DisplayScore(count);

                }


            }
        });

    }

    private void DisplayScoreodd(int counts) {
        int count =counts;
        score.setText("score"+String.valueOf(count));
        generate();
    }

    private void DisplayScore(int counts) {
        int count =counts;
        score.setText("score"+String.valueOf(count));
        generate();

    }
    public void begin(View view)
    {
        generate();
    }

    public void generate() {

        Random random = new Random();
        int OddOrEven = random.nextInt(101)+1;
        setOddOrEven(OddOrEven);
        displayScore.setText(String.valueOf(OddOrEven));


    }

}
