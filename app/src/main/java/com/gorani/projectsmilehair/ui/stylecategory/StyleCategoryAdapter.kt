package com.gorani.projectsmilehair.ui.stylecategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorani.projectsmilehair.databinding.ItemStyleCategoryBinding
import com.gorani.projectsmilehair.model.StyleCategory

class StyleCategoryAdapter(private val viewModel: StyleCategoryViewModel): ListAdapter<StyleCategory, StyleCategoryAdapter.StyleCategoryViewHolder>(StyleCategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StyleCategoryViewHolder {
        val binding = ItemStyleCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StyleCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StyleCategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class StyleCategoryViewHolder(private val binding : ItemStyleCategoryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(styleCategory: StyleCategory) {
            binding.viewModel = viewModel
            binding.styleCategory = styleCategory
            binding.executePendingBindings()
        }
    }
}

class StyleCategoryDiffCallback : DiffUtil.ItemCallback<StyleCategory>() {
    override fun areItemsTheSame(oldItem: StyleCategory, newItem: StyleCategory): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: StyleCategory, newItem: StyleCategory): Boolean {
        return oldItem == newItem
    }
}