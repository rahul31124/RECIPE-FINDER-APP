package com.example.mealrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.mealrecipes.databinding.ActivitySplashscreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class splashscreen : AppCompatActivity() {
    private lateinit var binding:ActivitySplashscreenBinding

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var foodViewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

        categoryViewModel = CategoryViewModel(application)
        foodViewModel = FoodViewModel(application)

        CoroutineScope(Dispatchers.Main).launch {
                populateDatabase(applicationContext, categoryViewModel, foodViewModel)

        }


    }
}