package com.hagerfamily.sparlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ImageView chromeIcon = findViewById(R.id.chromeButton);
        chromeIcon.setOnClickListener(onChromeButtonClick);
        chromeIcon.setImageDrawable(getActivityIcon(this,"com.android.chrome", "com.google.android.apps.chrome.Main"));

    }

    private View.OnClickListener onChromeButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
            startActivity(launchIntent);
        }
    };

    public static Drawable getActivityIcon(Context context, String packageName, String activityName) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
        return resolveInfo.loadIcon(pm);
    }


}
