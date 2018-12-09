package ir.phoenix_iran.mftvwork.Core;

import android.app.Application;
import android.util.Log;

import ir.phoenix_iran.mftvwork.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class CentralCore extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Font();
    }

    private void Font(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("exo2_light.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public static void tag(String text){
        Log.i("CentralCore", text);
    }

}
