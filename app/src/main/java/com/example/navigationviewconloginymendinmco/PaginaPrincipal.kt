package com.example.navigationviewconloginymendinmco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class PaginaPrincipal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null
    var  toolbar: Toolbar? = null

    lateinit var navView:NavigationView
    lateinit var navView2:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paginaprincipal)

        toolbar = findViewById<Toolbar>(R.id.toolbar);
        toolbar!!.title="App UTEQ"
        setContentView(R.layout.activity_paginaprincipal)

        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.menu)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        val bundle = this.getIntent().getExtras();
        var usu = bundle?.getString("Usuario")

        if(usu == "Jimmy"){
            val text = ("Ingreso: " + usu)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            navView = findViewById(R.id.nav_view)
            navView.setNavigationItemSelectedListener(this);
            

            var headerView: View=navView.getHeaderView(0)
            var userName:TextView=headerView.findViewById(R.id.txt_MostrarUsuario)
            userName.setText(bundle?.getString("Usuario"))
        }

        else{
            val text = ("Ingreso: " + usu)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            navView2 = findViewById(R.id.nav_view2)
            navView2.setNavigationItemSelectedListener(this);

            var headerView: View=navView2.getHeaderView(0)
            var userName:TextView=headerView.findViewById(R.id.txt_MostrarUsuario)
            userName.setText(bundle?.getString("Usuario"))

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
                drawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.menu_seccion_1 -> {
                fragment = Fragment1()
            }
            R.id.menu_seccion_2 -> {
                fragment = Fragment2()
            }
            R.id.menu_seccion_3 -> {
                fragment = Fragment3()
            }
        }

        if (fragment != null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit()

            item.setChecked(true)
            getSupportActionBar()?.setTitle(item.getTitle());
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }
}
