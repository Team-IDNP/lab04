package com.lab04.visitadoresmedicos

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lab04.visitadoresmedicos.databinding.ActivityVisitBinding
import com.lab04.visitadoresmedicos.model.Visita
import com.lab04.visitadoresmedicos.viewmodel.VisitaViewModel
import java.lang.NumberFormatException
import java.lang.StringBuilder

open class VisitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_visit)

        // Recuperar DNI del intent e insertarlo
        val dni = intent.getStringExtra("DNI") ?: ""

        val activityBinding = DataBindingUtil.setContentView<ActivityVisitBinding>(
            this,
            R.layout.activity_visit
        )
        activityBinding.viewModel = VisitaViewModel(this, dni)
        activityBinding.executePendingBindings()
    }

}
