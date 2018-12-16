package com.example.wilkinsonmaciel.animport

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista_automotivos.*
import kotlinx.android.synthetic.main.app_bar_lista_automotivos.*
import kotlinx.android.synthetic.main.content_lista_automotivos.*
import org.jetbrains.anko.toast

class lista_automotivos : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        var total = "0"
    }
    val itemList: MutableList<item_automotivo> = mutableListOf(
            item_automotivo("Limpeza de Bancos de Couro", "39.00", "Quero"),
            item_automotivo("Polimento Técnico", "39.00", "Quero"),
            item_automotivo("Restauração dos Para Brisas", "39.00", "Quero"),
            item_automotivo("Limpeza dos Plásticos Internos", "50.00", "Quero"),
            item_automotivo("Vitrificação de Pintura", "50.00", "Quero"),
            item_automotivo("Revitalização de Faróis", "50.00", "Quero"),
            item_automotivo("Limpeza detalhada do motor a seco", "50.00", "Quero")

    )

    internal lateinit var item_automotivoAdapter: item_automotivoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_automotivos)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {

            var i = 0
            //var total = "0"

           for(i in item_automotivoAdapter.checkeditem){
               total +=   "+" + i.preço
           }
             var total2 = eval(total)
            textView6.setText(total2.toString())
            toast("Processando Compra..")
            Handler().postDelayed({
                startActivity( Intent( this ,calendario::class.java) )
            }, 2000)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        item_automotivoAdapter = item_automotivoAdapter(this, itemList)
        recyclerView.adapter = item_automotivoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.smoothScrollToPosition(itemList.size)


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.lista_automotivos, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.carrinho -> {
                // Handle the camera action
            }
            R.id.alterar -> {

            }
            R.id.compras -> {

            }
            R.id.sobre -> {
                startActivity( Intent( this ,sobre::class.java) )
            }
            R.id.sair -> {
                startActivity( Intent( this ,MainActivity::class.java) )
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
