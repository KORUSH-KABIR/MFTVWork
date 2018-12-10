package ir.phoenix_iran.mftvwork.SecondExercises;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.Core.UserHelper;
import ir.phoenix_iran.mftvwork.R;

public class ProfileActivity extends SetupActivity {

    private UserHelper helper;
    private String name , username , email , password;
    private DrawerLayout drawerLayout;
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
        AppCompatImageView imgMenu = findViewById(R.id.imgMenu);
        RelativeLayout menuExit = findViewById(R.id.menuExit);
        drawerLayout = findViewById(R.id.drawerLayout);

        txtUsername.setText("@" + username);
        txtName.setText(name);
        txtEmail.setText(email);
        txtPassword.setText(password);

        txtUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditDetailActivity.class , username , REQUEST_CODE_EDIT_USERNAME);
            }
        });

        txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditDetailActivity.class , name , REQUEST_CODE_EDIT_NAME);
            }
        });

        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditDetailActivity.class , email , REQUEST_CODE_EDIT_EMAIL);
            }
        });

        txtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditDetailActivity.class , password , REQUEST_CODE_EDIT_PASSWORD);
            }
        });

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        menuExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.START);
                showDialog();
            }
        });
    }

    private void showDialog(){

        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("Exit");
        dialog.setMessage("Do You Want Exit?");
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
                overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
            }
        });
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    private void getDetail(){
        name     = helper.getName();
        username = helper.getUsername();
        email    = helper.getEmail();
        password = helper.getPassword();
    }

    private void startActivity(Class<? extends AppCompatActivity> activity , String text , int requestCode){
        Intent intent = new Intent(this , activity);
        intent.putExtra("text" , text);
        startActivityForResult(intent,requestCode);
        overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
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
        if(drawerLayout.isDrawerOpen(Gravity.START)){
            drawerLayout.closeDrawer(Gravity.START);
        }
        else {
            super.onBackPressed();
            overridePendingTransition(R.anim.anim_open_activity , R.anim.anim_close_activity);
        }
    }
}
