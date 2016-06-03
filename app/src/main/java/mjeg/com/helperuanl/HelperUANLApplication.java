package mjeg.com.helperuanl;

import android.app.Application;


import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

/**
 * Created by MJEG on 02/06/2016.
 */
public class HelperUANLApplication extends Application {
    @Override
    public void onCreate(){
        Parse.initialize(this, "R6SCGtPk0duFy275o3GYDNGMjNpf0gcGmmO25IAa", "56MQFIdELRyeW5klI1dP4h2GjNxW1oF5Wso8EPnC");
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
