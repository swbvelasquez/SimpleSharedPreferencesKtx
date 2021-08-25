package com.tutoriales.simplesharedpreferencesktx

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setView()
    }

    fun setView(){
        val lyProfile : LinearLayout = findViewById(R.id.layout_profile)
        val tvNombre : TextView = findViewById(R.id.textview_nombre)
        val btnSalir : Button = findViewById(R.id.button_salir)
        val intent = Intent(this,MainActivity::class.java)

        if (SharedApplication.generalPreferences.obtenerNombre().isNotEmpty()){
            tvNombre.text = SharedApplication.generalPreferences.obtenerNombre()
        }

        if(SharedApplication.generalPreferences.obtenerVIP()){
            lyProfile.setBackgroundColor(Color.YELLOW)
        }else{
            lyProfile.setBackgroundColor(Color.CYAN)
        }

        btnSalir.setOnClickListener {
            SharedApplication.generalPreferences.guardar("",false)
            startActivity(intent) }
    }
}