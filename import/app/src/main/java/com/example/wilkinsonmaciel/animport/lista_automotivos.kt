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
import kotlinx.android.synthetic.main.activity_lista_automotivos.*
import kotlinx.android.synthetic.main.app_bar_lista_automotivos.*
import kotlinx.android.synthetic.main.content_lista_automotivos.*

class lista_automotivos : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val itemList: MutableList<item_automotivo> = mutableListOf(
            item_automotivo("Adérito Tibiriçá", "atibirica@email.com", "1111-1111"),
            item_automotivo("Cleiton Siqueira ", "csiqueira@email.com", "2222-2222"),
            item_automotivo("Carlos Proença", "cproenca@email.com", "3333-3333"),
            item_automotivo("Filipe Valadão", "fvaladao@email.om", "4444-4444"),
            item_automotivo("Flávio Noite", "fnoite@email.com", "5555-5555")
    )

    lateinit var item_automotivoAdapter: item_automotivoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_automotivos)
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
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
