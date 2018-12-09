package ir.phoenix_iran.mftvwork.SecondExercises;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.R;

public class BaseActivity extends SetupActivity {

    private RelativeLayout baseLayout , loginLayout , registerLayout;
    private Button btnLogin , btnRegister;
    private boolean stateLogin = false;
    private boolean stateRegister = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!stateRegister){
                    if(!stateLogin){
                        openLoginLayout();
                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!stateLogin){
                    if(!stateRegister){
                        openRegisterLayout();
                    }
                }
            }
        });
    }

    private void initViews(){
        baseLayout = findViewById(R.id.baseLayout);
        loginLayout = findViewById(R.id.loginLayout);
        registerLayout = findViewById(R.id.registerLayout);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void openLoginLayout(){

        int fx = loginLayout.getRight();
        int fy = loginLayout.getBottom();
        Animator anim = null;
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            anim = ViewAnimationUtils.createCircularReveal(loginLayout , fx , fy , 0 , 2*fx);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    loginLayout.setVisibility(View.VISIBLE);
                    stateLogin = true;
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    baseLayout.setVisibility(View.INVISIBLE);
                }
            });
        }
        anim.setDuration(800);
        anim.start();
    }

    private void closeLoginLayout(){

        int fx = loginLayout.getRight();
        int fy = loginLayout.getBottom();
        Animator anim = null;
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            anim = ViewAnimationUtils.createCircularReveal(loginLayout , fx , fy , 2*fx , 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    baseLayout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    loginLayout.setVisibility(View.INVISIBLE);
                    stateLogin = false;
                }
            });
        }
        anim.setDuration(800);
        anim.start();
    }

    private void openRegisterLayout(){

        int fx = registerLayout.getRight();
        int fy = registerLayout.getBottom();
        Animator anim = null;
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            anim = ViewAnimationUtils.createCircularReveal(registerLayout , 0 , fy , 0 , 2*fx);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    registerLayout.setVisibility(View.VISIBLE);
                    stateRegister = true;
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    baseLayout.setVisibility(View.INVISIBLE);
                }
            });
        }
        anim.setDuration(800);
        anim.start();
    }

    private void closeRegisterLayout(){

        int fx = registerLayout.getRight();
        int fy = registerLayout.getBottom();
        Animator anim = null;
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            anim = ViewAnimationUtils.createCircularReveal(registerLayout , 0 , fy , 2*fx , 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    baseLayout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    registerLayout.setVisibility(View.INVISIBLE);
                    stateRegister = false;
                }
            });
        }
        anim.setDuration(800);
        anim.start();
    }

    private void startActivity(Class<? extends AppCompatActivity> activity){
        Intent intent = new Intent(this , activity);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
    }

    @Override
    public void onBackPressed() {
        if(stateLogin){
            closeLoginLayout();
        }
        else if(stateRegister){
            closeRegisterLayout();
        }
        else {
            super.onBackPressed();
        }
    }
}
