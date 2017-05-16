package myapp.surfer.com.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PresentacionActivity extends AppCompatActivity implements View.OnClickListener {

    Button btSiguiente, btAcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        btSiguiente = (Button) findViewById(R.id.btSiguiente);
        btSiguiente.setOnClickListener(this);

        btAcercaDe = (Button) findViewById(R.id.btAcercaDe);
        btAcercaDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btSiguiente:
                //Crear intent para redireccionar hacia otra activity
                //Debo enviar el contexto actual y la clase a la que se va redireccionar para que se ejecute
                Intent intent = new Intent(PresentacionActivity.this, MainActivity.class);

                startActivity(intent);
                break;
            case R.id.btAcercaDe:
                Log.d("DEBUG","btAcercaDe ejecutanto");
                Toast.makeText(getApplicationContext(),"Desarrollado Por Didier Albarran",Toast.LENGTH_LONG).show();
                Log.d("DEBUG","btAcercaDe terminó");
                break;
        }
    }
}
