package com.gorani.smilehair.ui.hairstyledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorani.smilehair.databinding.ItemHairStyleBinding
import com.gorani.smilehair.model.HairStyle

class RecommendedStyleAdapter: ListAdapter<HairStyle, RecommendedStyleAdapter.RecommendedStyleViewHolder>(RecommendedStyleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedStyleViewHolder {
        val binding = ItemHairStyleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendedStyleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedStyleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecommendedStyleViewHolder(private val binding: ItemHairStyleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hairStyle: HairStyle) {
            binding.hairStyle = hairStyle
            binding.executePendingBindings()
        }
    }
}

class RecommendedStyleDiffCallback : DiffUtil.ItemCallback<HairStyle>() {
    override fun areItemsTheSame(oldItem: HairStyle, newItem: HairStyle): Boolean {
        return oldItem.hairStyleId == newItem.hairStyleId
    }

    override fun areContentsTheSame(oldItem: HairStyle, newItem: HairStyle): Boolean {
        return oldItem == newItem
    }

}