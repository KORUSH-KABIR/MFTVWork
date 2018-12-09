package ir.phoenix_iran.mftvwork.SecondExercises;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.Core.UserHelper;
import ir.phoenix_iran.mftvwork.R;

public class BaseActivity extends SetupActivity {

    private static final int LENGTH_ANIMATION = 500;
    private RelativeLayout baseLayout , loginLayout , registerLayout;
    private Button btnLogin , btnRegister;
    private boolean stateLogin = false;
    private boolean stateRegister = false;
    private UserHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        helper = new UserHelper(this);

        if(helper.isRemember()){
            startActivity(ProfileActivity.class);
            finish();
        }

        initViews();
        initLoginLayout();
        initRegisterLayout();

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

    private void initLoginLayout(){

        final AppCompatEditText edtLoginUsername = findViewById(R.id.edtLoginUsername);
        final AppCompatEditText edtLoginPassword = findViewById(R.id.edtLoginPassword);
        final AppCompatCheckBox chb_remember = findViewById(R.id.chb_remember);
        AppCompatButton btnLoginLayout = findViewById(R.id.btnLoginLayout);

        btnLoginLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtLoginUsername.getText().toString().equals("")){
                    edtLoginUsername.setFocusable(true);
                    edtLoginUsername.setError("Username is Empty");
                }
                else if(edtLoginPassword.getText().toString().equals("")){
                    edtLoginPassword.setFocusable(true);
                    edtLoginPassword.setError("Password is Empty");
                }
                else if(edtLoginPassword.getText().length() < 4 || edtLoginPassword.getText().length() > 8){
                    edtLoginPassword.setFocusable(true);
                    edtLoginPassword.setError("The password must be greater than 3 letters and less than 9 characters.");
                }
                else {
                    if(chb_remember.isChecked()){
                        helper.setUsername(edtLoginUsername.getText().toString());
                        helper.setPassword(edtLoginPassword.getText().toString());
                        helper.setName("EMPTY");
                        helper.setEmail("EMPTY");
                        helper.setRemember(true);
                        startActivity(ProfileActivity.class);
                    }
                    else {
                        Toast.makeText(BaseActivity.this, "Please select remember me", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void initRegisterLayout(){

        final AppCompatEditText edtRegisterName       = findViewById(R.id.edtRegisterName);
        final AppCompatEditText edtRegisterUsername   = findViewById(R.id.edtRegisterUsername);
        final AppCompatEditText edtRegisterEmail      = findViewById(R.id.edtRegisterEmail);
        final AppCompatEditText edtRegisterPassword   = findViewById(R.id.edtRegisterPassword);
        final AppCompatCheckBox chb_remember_register = findViewById(R.id.chb_remember_register);
        AppCompatButton btnRegisterLayout = findViewById(R.id.btnRegisterLayout);

        btnRegisterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtRegisterName.getText().toString().equals("")){
                    edtRegisterName.setFocusable(true);
                    edtRegisterName.setError("Name is Empty");
                }
                else if(edtRegisterUsername.getText().toString().equals("")){
                    edtRegisterUsername.setFocusable(true);
                    edtRegisterUsername.setError("Username is Empty");
                }
                else if(edtRegisterEmail.getText().toString().equals("")){
                    edtRegisterEmail.setFocusable(true);
                    edtRegisterEmail.setError("Email is Empty");
                }
                else if(edtRegisterPassword.getText().toString().equals("")){
                    edtRegisterPassword.setFocusable(true);
                    edtRegisterPassword.setError("Password is Empty");
                }
                else if(edtRegisterPassword.getText().length() < 4 || edtRegisterPassword.getText().length() > 8){
                    edtRegisterPassword.setFocusable(true);
                    edtRegisterPassword.setError("The password must be greater than 3 letters and less than 9 characters.");
                }
                else {
                    if(chb_remember_register.isChecked()){
                        helper.setName(edtRegisterName.getText().toString());
                        helper.setUsername(edtRegisterUsername.getText().toString());
                        helper.setEmail(edtRegisterEmail.getText().toString());
                        helper.setPassword(edtRegisterPassword.getText().toString());
                        helper.setRemember(true);
                        startActivity(ProfileActivity.class);
                    }
                    else {
                        Toast.makeText(BaseActivity.this, "Please select remember me", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
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
        assert anim != null;
        anim.setDuration(LENGTH_ANIMATION);
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
        assert anim != null;
        anim.setDuration(LENGTH_ANIMATION);
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
        assert anim != null;
        anim.setDuration(LENGTH_ANIMATION);
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
        assert anim != null;
        anim.setDuration(LENGTH_ANIMATION);
        anim.start();
    }

    private void startActivity(Class<? extends AppCompatActivity> activity){
        Intent intent = new Intent(this , activity);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
        finish();
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
