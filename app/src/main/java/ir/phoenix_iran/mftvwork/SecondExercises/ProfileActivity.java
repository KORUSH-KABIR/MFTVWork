package ir.phoenix_iran.mftvwork.SecondExercises;

import android.os.Build;
import android.os.Bundle;
import android.widget.ProgressBar;

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

        ProgressBar prg1 = findViewById(R.id.prg1);
        prg1.setIndeterminate(false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            prg1.setProgress(80 , true);
        }
        else {
            prg1.setProgress(80);
        }
        prg1.setMax(100);


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
