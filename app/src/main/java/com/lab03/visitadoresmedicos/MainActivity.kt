package com.lab03.visitadoresmedicos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irAVisita(view: View) {
        val i = Intent(this, VisitActivity::class.java)
        startActivity(i)
    }

    var irAActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            ////////
        }
    }

    fun irARegistrarPaciente(view: View) {
        val intent = Intent(this, PacienteActivity::class.java)
        irAActivity.launch(intent)
    }

}
