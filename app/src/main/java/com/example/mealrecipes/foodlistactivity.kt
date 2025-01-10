package com.example.mealrecipes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipes.databinding.ActivityFoodlistactivityBinding

class FoodListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodlistactivityBinding
    private lateinit var foodViewModel: FoodViewModel
    private lateinit var foodAdapter: FoodAdapter
    private var categoryId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodlistactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        categoryId = intent.getStringExtra("categoryId").toString()

        binding.backbtnlist.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        foodAdapter = FoodAdapter({ clickedFood ->
            val intent = Intent(this, FoodDetailsActivity::class.java).apply {
                putExtra("name", clickedFood.name)
                putExtra("foodImageUrl", clickedFood.imageUrl)
            }
            startActivity(intent)
        }, { clickedFood, isFavorite ->
            clickedFood.isFavorite = isFavorite
            foodViewModel.updateFoodFavoriteStatus(clickedFood)
            if (isFavorite) {
                Toast.makeText(this, "Added to Favorite", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Removed from Favorite", Toast.LENGTH_SHORT).show()
            }
        }, { foodToDelete ->
            foodViewModel.deleteFood(foodToDelete)
            Toast.makeText(this, "Food item deleted", Toast.LENGTH_SHORT).show()
        })

        binding.foodrecycler.layoutManager = LinearLayoutManager(this)
        binding.foodrecycler.adapter = foodAdapter

        val searchQuery = intent.getStringExtra("searchQuery")
        if (!searchQuery.isNullOrBlank()) {
            binding.categoryclick.setText(searchQuery)
            binding.brack1.setText("")
            binding.dietclick.setText("")
            binding.brack2.setText("")
            observeSearchFoods(searchQuery)
        } else {
            binding.categoryclick.setText(categoryId)
            observeFilteredFoods()
        }
    }

    private fun observeFilteredFoods() {
        binding.categoryclick.setText(categoryId)
        val diet = intent.getStringExtra("diet") ?: "All"
        binding.brack1.setText("  (")
        binding.dietclick.setText(diet)
        binding.brack2.setText(")")

        if (diet == "All" && categoryId == "Favorite") {
            binding.brack1.setText("")
            binding.dietclick.setText("")
            binding.brack2.setText("")
            foodViewModel.getfavfood(categoryId).observe(this, { foods ->
                foods?.let {
                    if (it.isEmpty()) {
                        Toast.makeText(this, "No Items Are Added in Favorite", Toast.LENGTH_SHORT).show()
                    }
                    foodAdapter.submitList(it)
                }
            })
        } else {
            val isGlutenFree = diet == "Gluten-Free"
            val isVegan = diet == "Vegan"
            val isVegetarian = diet == "Vegetarian"
            val isLactoseFree = diet == "Lactose-Free"

            foodViewModel.getFilteredFoods(categoryId, isGlutenFree, isVegan, isVegetarian, isLactoseFree)
                .observe(this, { foods ->
                    foods?.let {
                        if (it.isEmpty()) {
                            Toast.makeText(this, "No Items Available For This Diet", Toast.LENGTH_SHORT).show()
                        }
                        foodAdapter.submitList(it)
                    }
                })
        }
    }

    private fun observeSearchFoods(searchQuery: String) {
        foodViewModel.searchFoods(searchQuery).observe(this, { foods ->
            foods?.let {
                if (it.isEmpty()) {
                    Toast.makeText(this, "No Items Found Matching Your Search", Toast.LENGTH_SHORT).show()
                }
                foodAdapter.submitList(it)
            }
        })
    }
}
