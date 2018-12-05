package vitoriaclean.vitoriaclean

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entrar.setOnClickListener{
            startActivity(Intent(applicationContext,ServicosActivity::class.java))
        }


    }
}

