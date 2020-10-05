package com.e.petagramsemana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

public class Contacto extends AppCompatActivity {

    private EditText nomCont, mailCont, mensaje;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nomCont= findViewById(R.id.nomCont);
        mailCont = findViewById(R.id.mailCont);
        mensaje = findViewById(R.id.mensaje);
        enviar = findViewById(R.id.mensaje);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
                Toast.makeText(getApplicationContext(),"Mensaje enviado",Toast.LENGTH_SHORT).show();
                mailCont.setText("");
                mensaje.setText("");
                nomCont.setText("");
            }
        });

    }

    private void sendEmail() {
        String mailRem = mailCont.getText().toString().trim();
        String miMail = "fakemail@gmail.com";
        String sub = nomCont.getText().toString();
        String contenido = mensaje.getText().toString();
        new SendMail("fake", "fakepass").execute(
                new SendMail.Mail(mailRem, miMail, sub, contenido)
        );
    }

}