package ir.phoenix_iran.mftvwork.SecondExercises;

import android.os.Bundle;

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



    }

    private void initViews(){



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
