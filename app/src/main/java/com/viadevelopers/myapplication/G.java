package com.viadevelopers.myapplication;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by USER on 13/12/2017.
 */

public class G extends Application {
    private static Typeface font;
    @Override
    public void onCreate() {
        super.onCreate();
        font = Typeface.createFromAsset(getAssets(),"irsans_font.ttf");
    }
    public Typeface getFont(){
        return font;
    }
}
