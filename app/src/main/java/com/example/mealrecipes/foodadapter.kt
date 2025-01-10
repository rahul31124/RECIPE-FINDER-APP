package com.example.mealrecipes

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FoodAdapter(
    private val onItemClick: (Food) -> Unit,
    private val onFavoriteClick: (Food, Boolean) -> Unit,
    private val onDeleteClick: (Food) -> Unit
) : ListAdapter<Food, FoodAdapter.FoodViewHolder>(FoodDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view, onFavoriteClick, onDeleteClick)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = getItem(position)
        holder.bind(food)
        holder.itemView.setOnClickListener {
            onItemClick(food)
        }
    }

    class FoodViewHolder(
        itemView: View,
        private val onFavoriteClick: (Food, Boolean) -> Unit,
        private val onDeleteClick: (Food) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val imgFood: ImageView = itemView.findViewById(R.id.img_food)
        private val foodName: TextView = itemView.findViewById(R.id.FoodName)
        private val tvDescription: TextView = itemView.findViewById(R.id.decelerate)
        private val btnFavorite: ImageView = itemView.findViewById(R.id.btnSave)

        fun bind(food: Food) {
            foodName.text = food.name
            tvDescription.text = food.description

            Glide.with(itemView.context)
                .load(food.imageUrl)
                .apply(RequestOptions.centerCropTransform())
                .into(imgFood)

            updateFavoriteIcon(food.isFavorite)

            btnFavorite.setOnClickListener {
                food.isFavorite = !food.isFavorite
                updateFavoriteIcon(food.isFavorite)
                onFavoriteClick(food, food.isFavorite)
            }

            itemView.setOnLongClickListener {
                if (food.categoryId == "Custom") {
                    showDeleteConfirmationDialog(itemView, food)
                }
                true
            }
        }

        private fun updateFavoriteIcon(isFavorite: Boolean) {
            btnFavorite.setImageResource(
                if (isFavorite) R.drawable.heartfilled else R.drawable.like
            )
        }

        private fun showDeleteConfirmationDialog(view: View, food: Food) {
            AlertDialog.Builder(view.context)
                .setTitle("Delete Food")
                .setMessage("Are you sure you want to delete this food item?")
                .setPositiveButton("Yes") { _, _ ->
                    onDeleteClick(food)
                }
                .setNegativeButton("No", null)
                .show()
        }
    }

    class FoodDiffCallback : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }
    }
}
