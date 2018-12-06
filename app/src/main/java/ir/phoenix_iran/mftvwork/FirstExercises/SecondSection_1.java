package ir.phoenix_iran.mftvwork.FirstExercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ir.phoenix_iran.mftvwork.R;

public class SecondSection_1 extends AppCompatActivity {

    private EditText edtFirstName , edtLastName , edtAge , edtPhone;
    private Button btnConfirm;
    private String firstName , lastName , age , phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_section_1);

        initViews();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstName = edtFirstName.getText().toString();
                lastName  = edtLastName.getText().toString();
                age       = edtAge.getText().toString();
                phone     = edtPhone.getText().toString();

                startActivity();
            }
        });

    }

    private void initViews(){
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName  = findViewById(R.id.edtLastName);
        edtAge       = findViewById(R.id.edtAge);
        edtPhone     = findViewById(R.id.edtPhone);
        btnConfirm   = findViewById(R.id.btnConfirm);
    }

    private void startActivity(){
        Intent intent = new Intent(this , SecondSection_2.class);
        intent.putExtra("firstName" , firstName);
        intent.putExtra("lastName"  , lastName);
        intent.putExtra("age"       , age);
        intent.putExtra("phone"     , phone);
        startActivity(intent);
    }

}
