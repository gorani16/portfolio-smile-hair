package com.gorani.projectsmilehair.ui.recommended_style

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorani.projectsmilehair.databinding.ItemRecommendedStyleBinding
import com.gorani.projectsmilehair.model.RecommendedStyle

class RecommendedStyleAdapter: ListAdapter<RecommendedStyle, RecommendedStyleAdapter.RecommendedStyleViewHolder>(RecommendedStyleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedStyleViewHolder {
        val binding = ItemRecommendedStyleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendedStyleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedStyleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecommendedStyleViewHolder(private val binding: ItemRecommendedStyleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recommendedStyle: RecommendedStyle) {
            binding.recommendedStyle = recommendedStyle
            binding.executePendingBindings()
        }
    }
}

class RecommendedStyleDiffCallback : DiffUtil.ItemCallback<RecommendedStyle>() {
    override fun areItemsTheSame(oldItem: RecommendedStyle, newItem: RecommendedStyle): Boolean {
        return oldItem.hairStyleId == newItem.hairStyleId
    }

    override fun areContentsTheSame(oldItem: RecommendedStyle, newItem: RecommendedStyle): Boolean {
        return oldItem == newItem
    }

}