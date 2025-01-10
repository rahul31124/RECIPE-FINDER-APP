package com.example.mealrecipes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.mealrecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var foodViewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        Glide.get(this).clearMemory()
        Thread { Glide.get(applicationContext).clearDiskCache() }.start()
        binding.addyourfood.setOnClickListener {
            val intent1=Intent(this,Createfood::class.java)
            startActivity(intent1)
        }

        binding.category.layoutManager = GridLayoutManager(this, 3)
        categoryAdapter = CategoryAdapter(object : CategoryAdapter.OnItemClickListener {
            override fun onItemClick(category: Category) {
                showDietPreferencesDialog(category.cname)
            }
        })
        binding.category.adapter = categoryAdapter

        categoryViewModel.allCategories.observe(this, { categories ->
            categories?.let {
                categoryAdapter.submitList(it)
            }
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query == ""){
                    Toast.makeText(this@MainActivity, "Please Enter a Valid Food Name", Toast.LENGTH_SHORT).show()
                }
                if (!query.isNullOrBlank()) {
                    val intent = Intent(this@MainActivity, FoodListActivity::class.java)
                    intent.putExtra("searchQuery", query.trim())
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, "Please Enter a Valid Food Name", Toast.LENGTH_SHORT).show()
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })






    }

    private fun showDietPreferencesDialog(categoryId: String) {
        if (categoryId == "Favorite") {
            navigateToFoodList(categoryId, "All")
            return
        }
        val dialogView = layoutInflater.inflate(R.layout.dialog_diet_preferences, null)
        val dietListView = dialogView.findViewById<ListView>(R.id.diet_list_view)

        val dietOptions = listOf("All", "Gluten-Free", "Vegetarian", "Vegan", "Lactose-Free")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dietOptions)
        dietListView.adapter = adapter

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dietListView.setOnItemClickListener { _, _, position, _ ->
            val selectedDiet = dietOptions[position]
            dialog.dismiss()
            navigateToFoodList(categoryId, selectedDiet)
        }

        dialog.show()
    }


    private fun navigateToFoodList(categoryId: String, diet: String) {
        val intent = Intent(this, FoodListActivity::class.java).apply {
            putExtra("categoryId", categoryId)
            putExtra("diet", diet)
        }
        startActivity(intent)
    }
}
