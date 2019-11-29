package com.dsoria.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var edtIngresaNum: EditText? = null
    private var txvPuntajeAc: TextView? = null
    private var txvNumeroCor: TextView?= null
    private var numero: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtIngresaNum = findViewById(R.id.edtNumero) as EditText
        txvPuntajeAc = findViewById(R.id.txvPuntajeA) as TextView
        txvNumeroCor = findViewById(R.id.txvNumCo) as TextView

        val prefe = getSharedPreferences("datos", Context.MODE_PRIVATE)
        val i = prefe.getInt("puntos", 0).toString()
        txvPuntajeA.setText(i)
        numero = 1 + (Math.random() * 50).toInt()

        btnVerificar.setOnClickListener {
            val valor = Integer.parseInt(edtNumero.getText().toString())
            if (numero == valor){
                var puntos = Integer.parseInt(
                    txvPuntajeA.getText().toString()
                )
                puntos++
                txvPuntajeA.setText(puntos.toString())
                txvNumCo.setText("HAS ACERTADO FELICIDADES")
                edtNumero.setText("")
                val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
                val edit = preferencias.edit()
                edit.putInt("puntos", puntos)
                edit.commit()
                numero = 1 + (Math.random() * 50).toInt()

            }    else {
                if (valor > numero) {

                    txvNumCo.setText("Intente con un numero MENOR ")
                } else {

                    txvNumCo.setText("Intente con un numero MAYOR")
                }
            }



        }

    }
}
