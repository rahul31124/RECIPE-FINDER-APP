package com.example.mealrecipes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface FoodDao {

    @Query("SELECT * FROM foods WHERE category_id = :categoryId")
    fun getFoodsByCategoryId(categoryId: String): LiveData<List<Food>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(foods: List<Food>)

    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food: Food)


    @Query("SELECT * FROM foods")
    suspend fun getAllFoods(): List<Food>


    @Delete
    suspend fun delete(food: Food)




    @Query("SELECT * FROM foods WHERE name= :foodId")
    fun getFoodById(foodId: String): LiveData<Food>
    @Query("SELECT * FROM foods WHERE name LIKE :name")
    fun getFoodsByName(name: String): LiveData<List<Food>>

    @Query("SELECT * FROM foods WHERE (:isGlutenFree IS NULL OR is_gluten_free = :isGlutenFree) AND (:isVegan IS NULL OR is_vegan = :isVegan) AND (:isVegetarian IS NULL OR is_vegetarian = :isVegetarian) AND (:isLactoseFree IS NULL OR is_lactose_free = :isLactoseFree)")
    fun getFoodsByDiet(
        isGlutenFree: Boolean?,
        isVegan: Boolean?,
        isVegetarian: Boolean?,
        isLactoseFree: Boolean?
    ): LiveData<List<Food>>


    @Update
    suspend fun update(food: Food)
    @Query("SELECT * FROM foods WHERE name LIKE '%' || :query || '%'")
    fun searchFoods(query: String): LiveData<List<Food>>

    @Query("SELECT name FROM foods WHERE name LIKE :searchQuery ORDER BY name ASC")
    fun getFoodNamesMatching(searchQuery: String): LiveData<List<String>>

    @Query("SELECT * FROM foods WHERE is_favorite = 1")
    fun getAllFavoriteFoods(): LiveData<List<Food>>

    @Query("SELECT COUNT(*) FROM foods")
    fun getFoodCount(): Int

    @Query("SELECT * FROM foods " +
            "WHERE category_id = :categoryId " +
            "AND (:isGlutenFree = 0 OR is_gluten_free = :isGlutenFree) " +
            "AND (:isVegan = 0 OR is_vegan = :isVegan) " +
            "AND (:isVegetarian = 0 OR is_vegetarian = :isVegetarian) " +
            "AND (:isLactoseFree = 0 OR is_lactose_free = :isLactoseFree)")
    fun getFilteredFoods(
        categoryId: String,
        isGlutenFree: Boolean,
        isVegan: Boolean,
        isVegetarian: Boolean,
        isLactoseFree: Boolean
    ): LiveData<List<Food>>

}
