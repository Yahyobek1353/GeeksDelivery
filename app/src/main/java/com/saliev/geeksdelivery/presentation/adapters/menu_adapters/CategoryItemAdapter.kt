package com.saliev.geeksdelivery.presentation.adapters.menu_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.saliev.geeksdelivery.databinding.ItemProductBinding
import com.saliev.geeksdelivery.presentation.model.CategoryItemUI
import com.saliev.geeksdelivery.presentation.utils.loadImageURL

class CategoryItemAdapter: ListAdapter<CategoryItemUI, CategoryItemAdapter.CategoryItemViewHolder>(CategoryItemDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CategoryItemViewHolder(private val binding: ItemProductBinding): ViewHolder(binding.root) {
        fun onBind(it: CategoryItemUI){
            binding.itemImgProduct.loadImageURL(it.image)
            binding.itemNameProduct.text = it.meal
        }
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)

    }

}
class CategoryItemDiffCallback: DiffUtil.ItemCallback<CategoryItemUI>() {
    override fun areItemsTheSame(
        oldItem: CategoryItemUI,
        newItem: CategoryItemUI
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CategoryItemUI,
        newItem: CategoryItemUI
    ): Boolean {
        return oldItem == newItem

    }

}
