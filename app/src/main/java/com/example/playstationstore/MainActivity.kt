package com.example.playstationstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playstationstore.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnMenu.setOnItemSelectedListener { item: MenuItem ->
            when (item.order) {
                1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.flFragmentHolder.id, Fragment_Main.newInstance()).commit()
                    true
                }
                2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.flFragmentHolder.id, Fragment_Overview.newInstance())
                        .commit()
                    true
                }
                3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.flFragmentHolder.id, Fragment_Store.newInstance()).commit()
                    true
                }
                4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.flFragmentHolder.id, Fragment_Library.newInstance())
                        .commit()
                    true
                }
                5 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.flFragmentHolder.id, Fragment_Search.newInstance())
                        .commit()
                    true
                }
                else -> true
            }

        }

//        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
//        val navController = navHostFragment.navController
//        binding.bnMenu.setupWithNavController(navController)
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.fragment_main,
//            R.id.fragment_overview,
//            R.id.fragment_store,
//            R.id.fragment_library,
//            R.id.fragment_search))
//        setupActionBarWithNavController(navController, appBarConfiguration)

//        <androidx.fragment.app.FragmentContainerView
//        android:id="@+id/fragmentContainerView"
//        android:name="androidx.navigation.fragment.NavHostFragment"
//        android:layout_width="0dp"
//        android:layout_height="wrap_content"
//        app:defaultNavHost="true"
//        app:navGraph="@navigation/bottom_navigation"
//        tools:layout_editor_absoluteX="1dp"
//        tools:layout_editor_absoluteY="344dp"
//        app:layout_constraintStart_toStartOf="@id/gl_margin_start"
//        app:layout_constraintEnd_toEndOf="@id/gl_margin_end"
//        app:layout_constraintTop_toBottomOf="@id/rvGameInfo"/>
    }
}