package com.lab03.visitadoresmedicos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irAVisita(view: View) {
        val i = Intent(this, VisitActivity::class.java)
        startActivity(i)
    }

}
