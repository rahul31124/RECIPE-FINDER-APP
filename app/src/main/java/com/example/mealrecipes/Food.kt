package com.example.mealrecipes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Food(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "category_id") val categoryId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "is_gluten_free") val isGlutenFree: Boolean,
    @ColumnInfo(name = "is_vegan") val isVegan: Boolean,
    @ColumnInfo(name = "is_vegetarian") val isVegetarian: Boolean,
    @ColumnInfo(name = "is_lactose_free") val isLactoseFree: Boolean,
    @ColumnInfo(name = "is_favorite") var isFavorite: Boolean = false,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "recipe_details") val recipeDetails: String
)
