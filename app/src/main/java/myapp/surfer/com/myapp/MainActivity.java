package myapp.surfer.com.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView campo_texto;
    EditText edUsuario;
    ImageView ivImagen;
    EditText edDato;
    Button button2, botonN, bActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo_texto = (TextView) findViewById(R.id.tvTexto);
        campo_texto.setText("Hola de nuevo Didier");
        ivImagen = (ImageView) findViewById(R.id.ivImagen);

        ivImagen.isClickable();

        edUsuario = (EditText)findViewById(R.id.etUsuario);
        edUsuario.setText("Cambiamos texto");

        edDato = (EditText)findViewById(R.id.etDato);
        button2 = (Button) findViewById(R.id.button2);
        botonN = (Button) findViewById(R.id.botonN);

        bActivity = (Button) findViewById(R.id.bActivity);

        button2.setOnClickListener(this);
        botonN.setOnClickListener(this);
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
            case R.id.button2:
                String dato = edDato.getText().toString();
                campo_texto.setText(dato);
                break;
            case R.id.botonN:
                //campo_texto.setText("Botón 2!!!");
                Toast.makeText(getApplicationContext(),"Esto es un Toast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bActivity:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
