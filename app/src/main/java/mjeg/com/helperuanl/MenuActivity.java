package mjeg.com.helperuanl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by MJEG on 28/05/2016.
 */
public class MenuActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        ImageButton mantButton = (ImageButton) findViewById(R.id.mantenimiento);
        mantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Reportes_mant.class);
                startActivity(intent);
            }

        });
        ImageButton limpButton = (ImageButton) findViewById(R.id.limpieza);
        limpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Reportes_limpieza.class);
                startActivity(intent);
            }

        });
        ImageButton saludButton = (ImageButton) findViewById(R.id.salud);
        saludButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Reportes_salud.class);
                startActivity(intent);
            }

        });
        ImageButton librosButton = (ImageButton) findViewById(R.id.libros);
        librosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Reportes_libros.class);
                startActivity(intent);
            }

        });
    }
}