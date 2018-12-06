package ir.phoenix_iran.mftvwork.FirstExercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import ir.phoenix_iran.mftvwork.R;

public class FirstSection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_section);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_first_section, menu);
        return true;
    }

}
