package com.tutoriales.simplesharedpreferencesktx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
    }

    fun setView(){
        try {
            val etNombre : EditText = findViewById(R.id.edittext_nombre)
            val chkVip : CheckBox = findViewById(R.id.checkbox_vip)
            val btnIngresar : Button = findViewById(R.id.button_ingresar)
            val intent = Intent(this,ProfileActivity::class.java)

            if (SharedApplication.generalPreferences.obtenerNombre().isNotEmpty()){
                startActivity(intent)
            }

            btnIngresar.setOnClickListener {
                if (etNombre.text.toString().isNotEmpty()) {
                    SharedApplication.generalPreferences.guardar(etNombre.text.toString(),chkVip.isChecked)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext,"Ingrese un valor", Toast.LENGTH_SHORT).show()
                }
            }
        }catch (e:Exception){

        }
    }
}