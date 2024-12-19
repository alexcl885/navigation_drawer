package com.example.examplenavigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.examplenavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binging : ActivityMainBinding
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)

        val toolbar = binging.main.appbARlayout

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController

        val navView = binging.myNavView

        appBarConfiguration =  AppBarConfiguration(
            setOf(R.id.fragmentA,R.id.fragmentB,R.id.fragmentC ) ,
            binding.main

        )

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, AppBarConfiguration)

        navView.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_op, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.fragmentA -> {
                navController.navigate(R.id.fragmentA)
            },
            R.id.fragmentC -> {
                navController.navigate(R.id.fragmentA)
            },
            R.id.fragmentC -> {
                navController.navigate(R.id.fragmentA)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}