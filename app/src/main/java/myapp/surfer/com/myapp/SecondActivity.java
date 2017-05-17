package myapp.surfer.com.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null)
        {
            String dato = extras.getString("USUARIO");
            tvSaludo = (TextView) findViewById(R.id.tvSaludoBienvenida);
            tvSaludo.setText("Bienvenido "+dato);
        }
    }
}
