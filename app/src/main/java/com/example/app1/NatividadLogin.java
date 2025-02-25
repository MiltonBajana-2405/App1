package com.example.app1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebService.WebService;
import WebService.Asynchtask;

public class NatividadLogin extends AppCompatActivity implements Asynchtask{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btlogin = findViewById(R.id.button2);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> datos = new HashMap<String, String>();
                WebService ws= new WebService(
                        "https://revistas.uteq.edu.ec/ws/login.php?usr=cristian&pass=123",
                        datos, NatividadLogin.this, NatividadLogin.this);
                ws.execute("GET");
            }
        });
    }
    @Override
    public void processFinish(String result) throws JSONException {
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
    }
}