package ejleone.githinji.cryptocon.Util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ej on 3/20/17.
 */

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "Bcredit";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     *
     * TODO:Add the is  boolean IS_LOgin =true
     * Create a Login Session */
    public void setStart()
    {
        editor.putString("Name","First");
        editor.putString("uid","0");
        editor.putString("Phone","0700686574");
        editor.commit();
    }


    /**
     *
     * TODO:Add the is  boolean IS_LOgin =true
     * Create a Login Session */
    public void setNameandPhone(String nm ,String Phone ,String uid)
    {
        editor.putString("Name",nm);
        editor.putString("uid",uid);
        editor.putString("Phone",Phone);
        editor.commit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public String getname()
    {
        return pref.getString("Name","User");
    }

    public String getphone()
    {
        return pref.getString("Phone","+2547000000");
    }

    public String getloanB()
    {
        return pref.getString("loanb","");
    }

    public void setloanB(String p)
    {
        editor.putString("loanb",p);
        editor.commit();
    }

    public String getuid()
    {
        return pref.getString("uid","");
    }


}
