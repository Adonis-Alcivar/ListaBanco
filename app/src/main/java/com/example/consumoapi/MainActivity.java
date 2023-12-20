package com.example.consumoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Enviar(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        Bundle b = new Bundle();
        intent.putExtras(b);
        starActivity(intent);
    }

    private void starActivity(Intent intent) {
    }

    public void clickLogin(View v){
        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        EditText txtUsuario= findViewById(R.id.txtusuario);
        EditText txtClaves= findViewById(R.id.txtclave);
        WebService ws= new WebService(
                "https://revistas.uteq.edu.ec/ws/login.php?usr=" + txtUsuario.getText().toString() +
                "&pass=" + txtClaves.getText().toString(),
                datos,
                MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
TextView txtrespuesta = findViewById(R.id.txtrespuesta);
txtrespuesta.setText(result);
    }
}