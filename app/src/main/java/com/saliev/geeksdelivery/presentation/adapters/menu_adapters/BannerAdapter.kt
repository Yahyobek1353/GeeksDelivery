package com.saliev.geeksdelivery.presentation.adapters.menu_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.databinding.ItemBannersBinding

class BannerAdapter:ListAdapter<CategoryDto, BannerAdapter.BannerViewHolder>(BannerDiffutil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            ItemBannersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class BannerViewHolder(private val binding: ItemBannersBinding):ViewHolder(binding.root) {
        fun onBind(it:CategoryDto){

        }
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
        holder.itemView.setOnClickListener {
        }
    }

}
class BannerDiffutil:DiffUtil.ItemCallback<CategoryDto>() {
    override fun areItemsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean {
        return oldItem == newItem

    }

}
