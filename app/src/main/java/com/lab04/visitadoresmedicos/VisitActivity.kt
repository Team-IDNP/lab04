package com.lab04.visitadoresmedicos

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lab04.visitadoresmedicos.Model.Visita
import java.lang.NumberFormatException
import java.lang.StringBuilder

class VisitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit)

        // Recuperar DNI del intent e insertarlo
        val dni = intent.getStringExtra("DNI") ?: ""
        val editTextDni = findViewById<EditText>(R.id.dni_id)
        editTextDni.text.insert(0, dni)
    }

    private fun recuperarTexto(id: Int): String = findViewById<EditText>(id).text.toString()

    /**
     * Intenta convertir el texto de un EditText a double,
     * si falla agrega un string a un StringBuilder
     * @param id El id del EditText del cual obtener la entrada
     * @param str El texto a agregar al StringBuilder si no se puede convertir la entrada a Double
     * @param stringBuilder El StringBuilder
     */
    private fun campoADouble(id: Int, str: String, stringBuilder: StringBuilder): Double {
        return try {
            recuperarTexto(id).toDouble()
        } catch (e: NumberFormatException) {
            stringBuilder.append(str)
            0.0
        }
    }

    fun registrarDatos(view: View) {
        // Indica al usuario que campos corregir (si existe alguno)
        val camposACorregir = StringBuilder()

        val dni = recuperarTexto(R.id.dni_id)
        val presion = campoADouble(R.id.presion_id, "presion - ", camposACorregir)
        val temperatura = campoADouble(R.id.temperatura_id, "temperatura - ", camposACorregir)
        val saturacion = campoADouble(R.id.saturacion_id, "saturacion - ", camposACorregir)

        val texto = findViewById<TextView>(R.id.msj_error)
        val campos = camposACorregir.toString()
        if (campos.isNotEmpty()) {
            texto.text = "Los siguientes campos son invalidos: - $campos"
            return
        } else {
            texto.text = ""
        }

        val visita = Visita(dni, presion, temperatura, saturacion)
        Almacen.visitas.add(visita)

        Log.d("VISIT_ACTIVITY", "Pacientes registrados:")
        for (v in Almacen.visitas) {
            Log.d("VISIT_ACTIVITY", v.toString())
        }

        // Regresar a activity Principal
        finish()
    }

}
