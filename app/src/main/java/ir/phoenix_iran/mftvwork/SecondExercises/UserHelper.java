package ir.phoenix_iran.mftvwork.SecondExercises;

import android.content.Context;

import ir.phoenix_iran.mftvwork.Core.SharedPreferenceUtils;

public class UserHelper {

    private SharedPreferenceUtils spu;
    private static final String SHARED_PREFERENCE_FILE = "SharedPreferenceUtils";
    private static final String KEY_USER_USERNAME      = "Username";
    private static final String KEY_USER_PASSWORD      = "Password";
    private static final String KEY_USER_NAME          = "Name";
    private static final String KEY_USER_EMAIL         = "Email";

    public UserHelper(Context context) {
        this.spu = new SharedPreferenceUtils(context);
    }

    public void setName(String name){
        spu.writeString(SHARED_PREFERENCE_FILE,
                KEY_USER_NAME,
                name
        );
    }

    public String getName(){
        return spu.readString(
                SHARED_PREFERENCE_FILE,
                KEY_USER_NAME,
                ""
        );
    }

    public void setUsername(String username){
        spu.writeString(SHARED_PREFERENCE_FILE,
                KEY_USER_USERNAME,
                username
        );
    }

    public String getUsername(){
        return spu.readString(SHARED_PREFERENCE_FILE,
                KEY_USER_USERNAME,
                ""
        );
    }

    public void setEmail(String email){
        spu.writeString(SHARED_PREFERENCE_FILE,
                KEY_USER_EMAIL,
                email
        );
    }

    public String getEmail(){
        return spu.readString(SHARED_PREFERENCE_FILE,
                KEY_USER_EMAIL,
                ""
        );
    }

    public void setPassword(String password){
        spu.writeString(SHARED_PREFERENCE_FILE,
                KEY_USER_PASSWORD,
                password
        );
    }

    public String getPassword(){
        return spu.readString(SHARED_PREFERENCE_FILE,
                KEY_USER_PASSWORD,
                ""
        );
    }

}
