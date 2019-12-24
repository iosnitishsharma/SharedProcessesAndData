package com.nitish.demos.shareprocessdemo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplaySharedImage extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sharedimage);

         // sharing image between two apps
        imageView = findViewById(R.id.image);
        imageView.setBackground(getDrawableByName());


    }

    private Drawable getDrawableByName(){
        String pkg = "com.nitish.demos.flavouringexample";
        Resources resources = null;
        final int resourceId;
        try {
            Context context = createPackageContext(pkg,
                    Context.CONTEXT_IGNORE_SECURITY);
            resources = context.getResources();
            resourceId = resources.getIdentifier("famousmonument", "drawable",
                    context.getPackageName());
            return  resources.getDrawable(resourceId);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
