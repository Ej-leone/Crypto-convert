package ejleone.githinji.cryptocon;

import android.content.Intent;
import android.os.Bundle;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;


import java.util.ArrayList;
import java.util.List;

import ejleone.githinji.cryptocon.UI.MainActivity;
import ejleone.githinji.cryptocon.Util.PrefManager;


public class IntroActivity extends OnboarderActivity {

    List<OnboarderPage> onboarderPages;
    PrefManager pref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_intro);

        pref = new PrefManager(this);
        if (!pref.isFirstTimeLaunch())
        {
            startActivity(new Intent(IntroActivity.this,MainActivity.class));
        }

        onboarderPages = new ArrayList<OnboarderPage>();

        // Create your first page
        OnboarderPage onboarderPage1 = new OnboarderPage("CryptoConvert", "",R.mipmap.ic_launcher);
        OnboarderPage onboarderPage2 = new OnboarderPage("Bitcoin", "Never go offline with,Affordable internet bundles", R.mipmap.ic_launcher);
        OnboarderPage onboarderPage3 = new OnboarderPage("Etheruem", "Pay water bills Stress free", R.mipmap.ic_launcher);

        // You can define title and description colors (by default white)
        onboarderPage1.setTitleColor(R.color.white);
        onboarderPage1.setDescriptionColor(R.color.white);

        onboarderPage2.setTitleColor(R.color.white);
        onboarderPage2.setDescriptionColor(R.color.white);

        onboarderPage3.setTitleColor(R.color.white);
        onboarderPage3.setDescriptionColor(R.color.white);

        // Don't forget to set background color for your page
        onboarderPage1.setBackgroundColor(R.color.darker_white);
        onboarderPage2.setBackgroundColor(R.color.bitcoinlogoback);
        onboarderPage3.setBackgroundColor(R.color.ethereumlogoback);


        // Add your pages to the list
        onboarderPages.add(onboarderPage1);
        onboarderPages.add(onboarderPage2);
        onboarderPages.add(onboarderPage3);

        // And pass your pages to 'setOnboardPagesReady' method
        setOnboardPagesReady(onboarderPages);




    }


    @Override
    public void onSkipButtonPressed() {
        // Optional: by default it skips onboarder to the end
        super.onSkipButtonPressed();

        // Define your actions when the user press 'Skip' button
        Intent ds  = new Intent(IntroActivity.this,MainActivity.class);
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        startActivity(ds);
    }

    @Override
    public void onFinishButtonPressed() {
        // Define your actions when the user press 'Finish' button
        Intent ds  = new Intent(IntroActivity.this,MainActivity.class);
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        startActivity(ds);
    }


}
