package com.example.navigationviewconloginymendinmco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtUsu = findViewById<EditText>(R.id.txt_usuario);
        val txtPass = findViewById<EditText>(R.id.txt_clave);
        val boton = findViewById<Button>(R.id.btn_Ingresar);


        boton.setOnClickListener {

            if (txtUsu.getText().toString().equals("Jimmy") &&
                txtPass.getText().toString().equals("1234"))
            {
                val intent = Intent(this@Login, PaginaPrincipal::class.java)
                val b = Bundle();
                b.putString("Usuario", txtUsu.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
            else if (txtUsu.getText().toString().equals("Ana") &&
                txtPass.getText().toString().equals("1234"))
            {
                val intent = Intent(this@Login, PaginaPrincipal::class.java)
                val b = Bundle();
                b.putString("Usuario", txtUsu.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
            else{
                val text = "Usuario Incorrecto"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }

    }
}