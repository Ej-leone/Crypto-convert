package ejleone.githinji.cryptocon.Util;

import android.app.Application;
import android.widget.ImageView;
import android.widget.RelativeLayout;


/**
 * Created by Ej on 08/10/16.
 */

public class InternetInfoPanel extends Application {

    protected static final String TAG = InternetInfoPanel.class.getName();
    private static InternetInfoPanel mInstance;
    private RelativeLayout rl;

    private ImageView iv_ok;


    @Override
    public void onCreate() {
        super.onCreate();


        mInstance = this;
    }

    public static synchronized InternetInfoPanel getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(NetworkChangeReceiver.ConnectivityReceiverListener listener) {
        NetworkChangeReceiver.connectivityReceiverListener = listener;
    }

    public ImageView getIv_ok(){
        return iv_ok;
    }

}
