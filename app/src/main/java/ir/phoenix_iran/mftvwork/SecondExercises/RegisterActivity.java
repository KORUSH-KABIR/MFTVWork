package ir.phoenix_iran.mftvwork.SecondExercises;

import android.os.Bundle;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.R;

public class RegisterActivity extends SetupActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
    }
}
