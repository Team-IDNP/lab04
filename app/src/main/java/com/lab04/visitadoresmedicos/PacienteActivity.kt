package com.lab04.visitadoresmedicos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lab04.visitadoresmedicos.databinding.ActivityPacienteBinding
import com.lab04.visitadoresmedicos.viewmodel.PacienteViewModel

open class PacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_paciente)

        val activityBinding = DataBindingUtil.setContentView<ActivityPacienteBinding>(
            this,
            R.layout.activity_paciente
        )
        activityBinding.viewModel = PacienteViewModel(this)
        activityBinding.executePendingBindings()
    }

}
