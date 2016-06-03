package mjeg.com.helperuanl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Created by MJEG on 29/05/2016.
 */
public class Reportes_libros extends Activity {
    Spinner spinnerEdificio;
    Spinner spinnerSalon;
    Spinner spinnerCaso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportes_libros);
        spinnerEdificio = (Spinner) findViewById(R.id.spinnerEdificio);
        spinnerSalon = (Spinner) findViewById(R.id.spinnerSalon);
        spinnerCaso = (Spinner) findViewById(R.id.spinnerCaso);
        Button btnstart = (Button) findViewById(R.id.btnenviar);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edif = spinnerEdificio.getSelectedItem().toString();
                String salon = spinnerSalon.getSelectedItem().toString();
                String caso = spinnerCaso.getSelectedItem().toString();

                ParseObject testObject = new ParseObject("Material_Para_Salon");
                testObject.put("Edificio", edif);
                testObject.put("Salon", salon);
                testObject.put("Caso", caso);
                testObject.saveInBackground(new SaveCallback() {
                    public void done(ParseException e) {
                        finish();
                        if (e == null) {
                            Toast.makeText(Reportes_libros.this, "Enviado Correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Reportes_libros.this, "Envio de reporte fallido, Vuelve a intentarlo", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }


        });

    }
}
