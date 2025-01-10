package com.example.mealrecipes

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.room.Room
import com.example.mealrecipes.databinding.ActivityCreatefoodBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Createfood : AppCompatActivity() {
    private lateinit var binding:ActivityCreatefoodBinding
    private var description: String = ""
    private var recipeDetails: String = ""
    private var ingrideints: String = ""
    private var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityCreatefoodBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val priorityArray = arrayOf("Select Diet", "Vegan", "Gluten-Free", "Vegetarian","Lactose-Free","None")
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            priorityArray
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner2.adapter = adapter
        }
        val items = listOf("Select an option", "Name", "Recipe Details", "Ingredients","Description")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    1 -> showEditingField("Name")
                    2 -> showEditingField("Recipe Details")
                    3 -> showEditingField("Ingredients")
                    4 -> showEditingField("Description")
                    else -> hideEditingField()
                }


                when (position) {
                    0 -> binding.setexttitlefood.setText("")
                    1 -> binding.setexttitlefood.setText("Name")
                    2 -> binding.setexttitlefood.setText("Recipe Details")
                    3 -> binding.setexttitlefood.setText("Ingredients")
                    4 -> binding.setexttitlefood.setText("Description")
                    else -> hideEditingField()
                }





            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                saveCurrentFieldText()
            }
        })

        if (savedInstanceState != null) {
            description = savedInstanceState.getString("description", "")
            recipeDetails = savedInstanceState.getString("recipeDetails", "")
            ingrideints=savedInstanceState.getString("ingrideints","")
            name = savedInstanceState.getString("name","")
            val currentEditingField = savedInstanceState.getInt("currentEditingField", 0)
            when (currentEditingField) {
                1 -> showEditingField("Name")
                2 -> showEditingField("Recipe Details")
                3 -> showEditingField("Ingredients")
                4 -> showEditingField("Description")
                else -> hideEditingField()
            }
        }


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"food_recipe_db"
        ).build()


    binding.savebutton.setOnClickListener{
     val imgurl = "https://img.freepik.com/free-vector/thai-cuisine-food-flat-illustration_1284-74042.jpg?t=st=1720947001~exp=1720950601~hmac=d78ef3a56461d3f95f3509855342bd7809a44acde52cba53de99c59050a64f26&w=740"
     val catid= "Custom"
        val diet =binding.spinner2.selectedItem.toString()
        val isGlutenFree = diet == "Gluten-Free"
        val isVegan = diet == "Vegan"
        val isVegetarian = diet == "Vegetarian"
        val isLactoseFree = diet == "Lactose-Free"









        if (description!=""&&recipeDetails!=""&&ingrideints!=""&&diet!="Select Diet"){
            Toast.makeText(this, "Saved To Custom", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {
                db.foodDao().insert(Food(0,catid,name,description,imgurl,isGlutenFree,isVegan,isVegetarian,isLactoseFree,false,ingrideints,recipeDetails))
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        else{

            Toast.makeText(this, "Please Enter All The Details", Toast.LENGTH_SHORT).show()
        }




    }








    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("description", description)
        outState.putString("recipeDetails", recipeDetails)
        outState.putString("ingrideints",ingrideints)
        outState.putString("name",name)
        outState.putInt("currentEditingField", getCurrentEditingField())
    }

    private fun showEditingField(field: String) {
        binding.editText.visibility = View.VISIBLE
        binding.editText.hint = "$field"
        when (field) {
            "Description" -> binding.editText.setText(description)
            "Recipe Details" -> binding.editText.setText(recipeDetails)
            "Ingredients" -> binding.editText.setText(ingrideints)
            "Name" -> binding.editText.setText(name)
        }
    }

    private fun hideEditingField() {
        binding.editText.visibility = View.GONE
    }

    private fun saveCurrentFieldText() {
        when (getCurrentEditingField()) {
            1 -> name = binding.editText.text.toString()
            2 -> recipeDetails = binding.editText.text.toString()
            3 -> ingrideints  = binding.editText.text.toString()
            4 -> description = binding.editText.text.toString()
        }
    }

    private fun getCurrentEditingField(): Int {
        return when (binding.spinner.selectedItemPosition) {
            1 -> 1
            2 -> 2
            3 -> 3
            4 -> 4
            else -> 0
        }
    }
}