package com.slowmotion.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.slowmotion.foodapp.R
import com.slowmotion.foodapp.databinding.ActivityDetailBinding
import com.slowmotion.foodapp.model.Recipes

class DetailActivity : AppCompatActivity() {
    companion object{
        const val RECIPE_DATA = "recipes_data"
    }

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
        setSupportActionBar(detailBinding.tbDetail)
        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPE_DATA) as Recipes

        Glide.with(this).load(dataRecipes.pictures).into(detailBinding.ivDetail)
        detailBinding.NameDetail.text = dataRecipes.name
        detailBinding.tvCalories.text = dataRecipes.calories
        detailBinding.tvCarbo.text = dataRecipes.carbo
        detailBinding.tvProtein.text = dataRecipes.protein
        detailBinding.tvDetailadescription.text = dataRecipes.description
        detailBinding.tvIngredients.text = dataRecipes.ingredients
        detailBinding.tvInstrction.text = dataRecipes.instructions

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}