package ir.phoenix_iran.mftvwork.FirstExercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.phoenix_iran.mftvwork.R;

public class SecondSection_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_section_2);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName  = intent.getStringExtra("lastName");
        String age       = intent.getStringExtra("age");
        String phone     = intent.getStringExtra("phone");

        TextView txtFirstName = findViewById(R.id.txtFirstName);
        TextView txtLastName  = findViewById(R.id.txtLastName);
        TextView txtAge       = findViewById(R.id.txtAge);
        TextView txtPhone     = findViewById(R.id.txtPhone);

        txtFirstName.setText(firstName);
        txtLastName.setText(lastName);
        txtAge.setText(age);
        txtPhone.setText(phone);

    }
}
