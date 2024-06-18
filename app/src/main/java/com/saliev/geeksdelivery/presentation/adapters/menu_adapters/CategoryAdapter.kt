package com.saliev.geeksdelivery.presentation.adapters.menu_adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.databinding.ItemCategoryBinding
import com.saliev.geeksdelivery.presentation.model.CategoryUI

class CategoryAdapter:ListAdapter<CategoryUI, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding):ViewHolder(binding.root) {
        fun onBind(it:CategoryUI){
            binding.itemNameCategory.text = it.name
        }
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)

    }

}
class CategoryDiffCallback:DiffUtil.ItemCallback<CategoryUI>() {
    override fun areItemsTheSame(
        oldItem: CategoryUI,
        newItem: CategoryUI
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CategoryUI,
        newItem: CategoryUI
    ): Boolean {
        return oldItem == newItem

    }

}
