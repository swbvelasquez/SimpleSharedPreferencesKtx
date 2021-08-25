package com.tutoriales.simplesharedpreferencesktx

import android.content.Context
import android.content.SharedPreferences

class Preferences(context:Context) {
    val SHARED_DB_NAME = "MyDataBase"
    val SHARED_USER_NAME = "UserName"
    val SHARED_USER_VIP = "UserVIP"
    var storage:SharedPreferences

    init {
        storage = context.getSharedPreferences(SHARED_DB_NAME,0) // 0 modo privado
    }

    fun guardar(name:String, vip: Boolean){
        try {
            val storageEditor: SharedPreferences.Editor = storage.edit()
            storageEditor.putString(SHARED_USER_NAME, name)
            storageEditor.putBoolean(SHARED_USER_VIP, vip)
            storageEditor.apply()
            storageEditor.clear()
        }catch (e:Exception){

        }
    }

    fun obtenerNombre(): String {
        var nombre:String=""
        try {
            nombre = storage.getString(SHARED_USER_NAME,"").toString()
        }catch (e:Exception){

        }
        return nombre
    }

    fun obtenerVIP(): Boolean {
        var vip:Boolean=false
        try {
            vip = storage.getBoolean(SHARED_USER_VIP,false)
        }catch (e:Exception){

        }
        return vip
    }
}