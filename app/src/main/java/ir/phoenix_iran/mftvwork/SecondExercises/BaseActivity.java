package ir.phoenix_iran.mftvwork.SecondExercises;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ir.phoenix_iran.mftvwork.Core.SetupActivity;
import ir.phoenix_iran.mftvwork.R;

public class BaseActivity extends SetupActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }
}
