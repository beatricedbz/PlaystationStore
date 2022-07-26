package com.example.playstationstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.playstationstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnMenu.setOnItemSelectedListener { item: MenuItem -> switchFrags(item); true
        }

    }

    private fun switchFrags(item: MenuItem){
        when (item.order) {
            1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(binding.flFragmentHolder.id, FragmentMain.newInstance()).commit()
            }
            2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(binding.flFragmentHolder.id, FragmentOverview.newInstance())
                    .commit()
            }
            3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(binding.flFragmentHolder.id, FragmentStore.newInstance()).commit()
            }
            4 -> {
                supportFragmentManager.beginTransaction()
                    .replace(binding.flFragmentHolder.id, FragmentLibrary.newInstance())
                    .commit()
            }
            5 -> {
                supportFragmentManager.beginTransaction()
                    .replace(binding.flFragmentHolder.id, FragmentSearch.newInstance())
                    .commit()
            }
            else -> false
        }
    }
}