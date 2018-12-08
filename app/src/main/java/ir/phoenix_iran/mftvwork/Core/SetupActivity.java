package ir.phoenix_iran.mftvwork.Core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNotificationBar();
    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void setNotificationBar() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT &&
                    Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT_WATCH){
                w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS ,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS ,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION ,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    }

}
