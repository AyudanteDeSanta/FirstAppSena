package myapp.surfer.com.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {
    TextView campo_texto;
    EditText edUsuario, edContrasena;
    ImageView ivImagen;
    EditText edDato;
    Button btCambiarDato, bActivity;
    LinearLayout ln;
    Sensor sensor;
    SensorManager sl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ln = (LinearLayout) findViewById(R.id.linear);
        sl = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sl.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sl.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        campo_texto = (TextView) findViewById(R.id.tvTexto);
        campo_texto.setText("Hola de nuevo Didier");
        ivImagen = (ImageView) findViewById(R.id.ivImagen);

        ivImagen.isClickable();

        edUsuario = (EditText)findViewById(R.id.etUsuario);
        //edUsuario.setText("Cambiamos texto");
        edContrasena = (EditText)findViewById(R.id.etContrasena);

        edDato = (EditText)findViewById(R.id.etDato);
        btCambiarDato = (Button) findViewById(R.id.btCambiarDato);

        bActivity = (Button) findViewById(R.id.bActivity);

        btCambiarDato.setOnClickListener(this);
        bActivity.setOnClickListener(this);

        Log.d("DEBUG", "onCreate llamado");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("DEBUG","onResume llamado");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("DEBUG","onPause llamado");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btCambiarDato:
                String dato = edDato.getText().toString();
                campo_texto.setText(dato);
                break;
//            case R.id.botonN:
//                //campo_texto.setText("Botón 2!!!");
//                Toast.makeText(getApplicationContext(),"Esto es un Toast",Toast.LENGTH_SHORT).show();
//                break
            case R.id.bActivity:
                if (edUsuario.getText().toString().matches(""))
                {
                    Toast.makeText(getApplicationContext(),"Es requerido el nombre de usuario",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edContrasena.getText().toString().matches(""))
                {
                    Toast.makeText(getApplicationContext(),"Es requerido la contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("USUARIO", edUsuario.getText().toString());
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String texto = String.valueOf(event.values[0]);
        campo_texto.setText(texto);

        float retorno = Float.parseFloat(texto);
        if (retorno==0)
        {
            ln.setBackgroundColor(Color.BLUE);
        }
        else
        {
            ln.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
