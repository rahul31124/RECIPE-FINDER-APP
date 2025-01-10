package com.example.mealrecipes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel(application: Application) : AndroidViewModel(application) {

    private val foodDao = AppDatabase.getDatabase(application).foodDao()
    fun getAllCategories(): LiveData<List<Category>> {
        return foodDao.getAllCategories()
    }
    fun insertFood(food: Food) {
        viewModelScope.launch(Dispatchers.IO) {
            foodDao.insert(food)
        }
    }

    fun getFoodById(foodId: String): LiveData<Food> {
        return foodDao.getFoodById(foodId)
    }


    fun insertAllFoods(foods: List<Food>) {
        viewModelScope.launch(Dispatchers.IO) {
            val existingFoods = foodDao.getAllFoods()
            if (existingFoods.isEmpty()) {
                foodDao.insertAll(foods)
            }
        }
    }

    fun deleteFood(food: Food) {
        viewModelScope.launch(Dispatchers.IO) {
            foodDao.delete(food)
        }
    }

    fun updateFoodFavoriteStatus(food: Food) {
        viewModelScope.launch(Dispatchers.IO) {
            foodDao.update(food)
        }
    }

    fun getfavfood(categoryId: String) : LiveData<List<Food>> {
        return foodDao.getAllFavoriteFoods()
    }
    fun searchFoods(query: String): LiveData<List<Food>> {
        return foodDao.searchFoods("%$query")
    }

    fun getFilteredFoods(categoryId: String, isGlutenFree: Boolean?, isVegan: Boolean?, isVegetarian: Boolean?, isLactoseFree: Boolean?): LiveData<List<Food>> {
     if (categoryId == "Favorite"){
         foodDao.getAllFavoriteFoods()
     }
        return if (isGlutenFree == null && isVegan == null && isVegetarian == null && isLactoseFree == null ) {
            foodDao.getFoodsByCategoryId(categoryId)
        } else {
            foodDao.getFilteredFoods(
                categoryId,
                isGlutenFree ?: false,
                isVegan ?: false,
                isVegetarian ?: false,
                isLactoseFree ?: false
            )
        }
    }


}
