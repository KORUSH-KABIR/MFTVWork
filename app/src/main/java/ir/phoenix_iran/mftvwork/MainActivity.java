package ir.phoenix_iran.mftvwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton firstExercise , secondExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstExercise = findViewById(R.id.firstExercise);
        secondExercise = findViewById(R.id.secondExercise);

        firstExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FirstExerciseActivity.class);
            }
        });

        secondExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SecondExerciseActivity.class);
            }
        });

    }

    private void startActivity(Class<? extends AppCompatActivity> activity){
        Intent intent = new Intent(this , activity);
        startActivity(intent);
    }

}
