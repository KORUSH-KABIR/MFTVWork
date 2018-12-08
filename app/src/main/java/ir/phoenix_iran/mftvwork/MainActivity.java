package ir.phoenix_iran.mftvwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import ir.phoenix_iran.mftvwork.FirstExercises.FirstSection;
import ir.phoenix_iran.mftvwork.FirstExercises.SecondSection_1;
import ir.phoenix_iran.mftvwork.SecondExercises.BaseActivity;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton firstExercise , secondExercise , thirdExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstExercise = findViewById(R.id.firstExercise);
        secondExercise = findViewById(R.id.secondExercise);
        thirdExercise = findViewById(R.id.thirdExercise);

        firstExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FirstSection.class);
            }
        });

        secondExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SecondSection_1.class);
            }
        });

        thirdExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(BaseActivity.class);
            }
        });

    }

    private void startActivity(Class<? extends AppCompatActivity> activity){
        Intent intent = new Intent(this , activity);
        startActivity(intent);
    }

}
