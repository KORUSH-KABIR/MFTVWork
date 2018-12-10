package ir.phoenix_iran.mftvwork.SecondExercises;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.R;

public class EditDetailActivity extends SetupActivity {

    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_detail);

        initText();

        final AppCompatEditText edtDetail = findViewById(R.id.edtDetail);
        edtDetail.setText(text);
        AppCompatButton btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtDetail.getText().toString().equals(text)){
                    edtDetail.setFocusable(true);
                    edtDetail.setError("Input is Duplicate");
                }
                else if(edtDetail.getText().toString().equals("")){
                    edtDetail.setFocusable(true);
                    edtDetail.setError("Input is Empty");
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("data" , edtDetail.getText().toString());
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
                }
            }
        });
    }

    private void initText(){
        Intent intent = getIntent();
        text = intent.getStringExtra("text");
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    public void onBackPressed() {

    }
}
