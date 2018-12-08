package com.example.wilkinsonmaciel.animport

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_lista_residencial.*
import kotlinx.android.synthetic.main.app_bar_lista_residencial.*
import kotlinx.android.synthetic.main.content_lista_residencial.*

class lista_residencial : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val itemList: MutableList<item_residencial> = mutableListOf(
            item_residencial("Adérito Tibiriçá", "atibirica@email.com", "1111-1111"),
            item_residencial("Cleiton Siqueira ", "csiqueira@email.com", "2222-2222"),
            item_residencial("Carlos Proença", "cproenca@email.com", "3333-3333"),
            item_residencial("Filipe Valadão", "fvaladao@email.om", "4444-4444"),
            item_residencial("Flávio Noite", "fnoite@email.com", "5555-5555"),
            item_residencial("Gisela Siebra", "gsiebra@email.com", "6666-6666"),
            item_residencial("Marco Lousã", "mlousa@email.com", "7777-7777"),
            item_residencial("Miriam Tabosa", "mtabosa@email.com", "8888-8888"),
            item_residencial("Rufus Ramírez", "rramirez@email.com", "9999-9999"),
            item_residencial("Socorro Cabreira", "scabreira@email.com", "1010-1010")
    )

    lateinit var item_residencialAdapter: item_residencialAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_residencial)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        item_residencialAdapter = item_residencialAdapter(this, itemList)
        recyclerView2.adapter = item_residencialAdapter
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.smoothScrollToPosition(itemList.size)

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
        menuInflater.inflate(R.menu.lista_residencial, menu)
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

            }
            R.id.sair -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
