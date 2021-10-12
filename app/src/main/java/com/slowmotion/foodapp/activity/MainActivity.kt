package com.slowmotion.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.slowmotion.foodapp.R
import com.slowmotion.foodapp.databinding.ActivityMainBinding
import com.slowmotion.foodapp.fragment.BreakfastFragment
import com.slowmotion.foodapp.fragment.DessertFragment
import com.slowmotion.foodapp.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setCurrentFragment(BreakfastFragment())
        mainBinding.navMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.icBreakfast -> setCurrentFragment(BreakfastFragment())
                R.id.icVegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.icDessert -> setCurrentFragment(DessertFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, fragment)
            commit()
        }
    }
}