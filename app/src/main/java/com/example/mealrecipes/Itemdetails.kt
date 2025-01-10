package com.example.mealrecipes

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mealrecipes.databinding.ActivityFooddetailsBinding
import androidx.lifecycle.ViewModelProvider

class FoodDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFooddetailsBinding
    private lateinit var foodViewModel: FoodViewModel
    private lateinit var food: Food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFooddetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
     binding.backButton.setOnClickListener {
         onBackPressed()
     }
        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        val foodId = intent.getStringExtra("name")
        val foodImageUrl = intent.getStringExtra("foodImageUrl")

        Glide.with(this)
            .load(foodImageUrl)
            .into(binding.itemdetailsimg)

        if (foodId != null) {
            foodViewModel.getFoodById(foodId).observe(this, { fetchedFood ->
                fetchedFood?.let {
                    food = it
                    binding.foodName.text = food.name
                    displayFoodDetails("ingredients")
                }
            })
        }



        
        binding.setext.setText("Ingredients")
        
        binding.arrowup.setOnClickListener {
            if (binding.motionLayout.currentState == R.id.start) {
                binding.motionLayout.transitionToEnd()
            } else {
                binding.motionLayout.transitionToStart()
            }
        }

        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        binding.ingredients.setOnClickListener {
            it.startAnimation(scaleAnimation)
            binding.setext.setText("Ingredients")
            displayFoodDetails("ingredients")
        }

        binding.recipeDetails.setOnClickListener {
            it.startAnimation(scaleAnimation)
            binding.setext.setText("Recipe Details")
            displayFoodDetails("recipeDetails")
        }

        binding.backButton.setOnClickListener {
          onBackPressed()
        }
    }
    private fun displayFoodDetails(type: String) {
        val detailsText = when (type) {
            "ingredients" -> formatTex(food.ingredients)
            "recipeDetails" -> formatTex(food.recipeDetails)
            else -> ""
        }
        binding.displayitems.text = detailsText
    }

    private fun formatTex(details: String): String {
        val emoji = "\uD83D\uDC68\u200D\uD83C\uDF73"
        val formattedText = details
            .split("\n")
            .filter { it.isNotBlank() }
            .joinToString(separator = "\n\n") { "$emoji $it" }
        return formattedText
    }


}
