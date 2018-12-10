package ir.phoenix_iran.mftvwork.SecondExercises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.Core.UserHelper;
import ir.phoenix_iran.mftvwork.R;

public class ProfileActivity extends SetupActivity {

    private UserHelper helper;
    private String name , username , email , password;
    private static final int REQUEST_CODE_EDIT_USERNAME = 0;
    private static final int REQUEST_CODE_EDIT_NAME     = 1;
    private static final int REQUEST_CODE_EDIT_EMAIL    = 2;
    private static final int REQUEST_CODE_EDIT_PASSWORD = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        helper = new UserHelper(this);
        getDetail();
        initViews();
    }

    private void initViews(){

        Toast.makeText(this, "Select Your Detail for Change", Toast.LENGTH_SHORT).show();

        TextView txtUsername = findViewById(R.id.txtUsername);
        TextView txtName     = findViewById(R.id.txtName);
        TextView txtEmail    = findViewById(R.id.txtEmail);
        TextView txtPassword = findViewById(R.id.txtPassword);

        txtUsername.setText("@" + username);
        txtName.setText(name);
        txtEmail.setText(email);
        txtPassword.setText(password);

        txtUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        txtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getDetail(){
        name     = helper.getName();
        username = helper.getUsername();
        email    = helper.getEmail();
        password = helper.getPassword();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_EDIT_USERNAME){
            if(resultCode == Activity.RESULT_OK){
                String username = data.getStringExtra("data");
                helper.setUsername(username);
                Toast.makeText(this, "Username Updated...", Toast.LENGTH_LONG).show();
                recreate();
            }
        }
        else if(requestCode == REQUEST_CODE_EDIT_NAME){
            if(resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("data");
                helper.setName(name);
                Toast.makeText(this, "Name Updated...", Toast.LENGTH_LONG).show();
                recreate();
            }
        }
        else if(requestCode == REQUEST_CODE_EDIT_EMAIL){
            if(resultCode == Activity.RESULT_OK){
                String email = data.getStringExtra("data");
                helper.setEmail(email);
                Toast.makeText(this, "Email Updated...", Toast.LENGTH_LONG).show();
                recreate();
            }
        }
        else if(requestCode == REQUEST_CODE_EDIT_PASSWORD){
            if(resultCode == Activity.RESULT_OK){
                String password = data.getStringExtra("data");
                helper.setPassword(password);
                Toast.makeText(this, "Password Updated...", Toast.LENGTH_LONG).show();
                recreate();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
    }
}
