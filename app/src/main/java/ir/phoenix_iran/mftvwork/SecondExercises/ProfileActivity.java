package ir.phoenix_iran.mftvwork.SecondExercises;

import android.os.Bundle;
import android.widget.TextView;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.Core.UserHelper;
import ir.phoenix_iran.mftvwork.R;

public class ProfileActivity extends SetupActivity {

    private UserHelper helper;
    private String name , username , email , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        helper = new UserHelper(this);
        getDetail();
        initViews();
    }

    private void initViews(){

        TextView txtUsername = findViewById(R.id.txtUsername);
        TextView txtName     = findViewById(R.id.txtName);
        TextView txtEmail    = findViewById(R.id.txtEmail);
        TextView txtPassword = findViewById(R.id.txtPassword);

        txtUsername.setText(username);
        txtName.setText(name);
        txtEmail.setText(email);
        txtPassword.setText(password);

    }

    private void getDetail(){
        name     = helper.getName();
        username = helper.getUsername();
        email    = helper.getEmail();
        password = helper.getPassword();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
    }
}
