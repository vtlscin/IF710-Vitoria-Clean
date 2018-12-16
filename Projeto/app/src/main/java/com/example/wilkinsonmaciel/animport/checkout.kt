package com.example.wilkinsonmaciel.animport

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wilkinsonmaciel.animport.calendario.Companion.date
import com.example.wilkinsonmaciel.animport.lista_automotivos.Companion.total
import com.example.wilkinsonmaciel.animport.lista_residencial.Companion.checagem
import com.example.wilkinsonmaciel.animport.lista_residencial.Companion.total2
import kotlinx.android.synthetic.main.activity_checkout.*

class checkout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        if(checagem == false){
            textView14.text = total.toString()
            textView16.text = date

        }else{
            textView14.text = total2.toString()
            textView16.text = date
        }

        button.setOnClickListener{
            startActivity( Intent( this , Main2Activity::class.java) )
        }

    }
}
