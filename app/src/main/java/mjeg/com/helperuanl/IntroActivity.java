package mjeg.com.helperuanl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.parse.ParseInstallation;


/**
 * Created by MJEG on 28/05/2016.
 */
public class IntroActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
        Button btnstart = (Button) findViewById(R.id.btnstart);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String appType = sharedPref.getString("APP_TYPE","");

        if (appType.length() > 0)
        {
            findViewById(R.id.emes).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.emes).setVisibility(View.VISIBLE);
        }

    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        SharedPreferences sharedPref=null;
        SharedPreferences.Editor editor=null;
        ParseInstallation installation=null;

        switch(view.getId()) {

            case R.id.radio_alumno:
                if (checked)
                    Log.i("INFORMATION", "Alumno");
               sharedPref =getPreferences(Context.MODE_PRIVATE);
                 editor = sharedPref.edit();
                editor.putString("APP_TYPE","ES");
                editor.commit();
                installation = ParseInstallation.getCurrentInstallation();
                installation.put("DEVICE_TYPE", "estudiante");
                installation.saveEventually();
                break;
            case R.id.radio_empleado:
                if (checked)
                    Log.i("INFORMATION", "Empleado");
                sharedPref = getPreferences(Context.MODE_PRIVATE);
                 editor = sharedPref.edit();
                editor.putString("APP_TYPE","EM");
                editor.commit();
                 installation = ParseInstallation.getCurrentInstallation();
                installation.put("DEVICE_TYPE", "empleado");
                installation.saveEventually();

                break;
        }
    }
}
