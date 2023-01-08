package com.gorani.projectsmilehair.ui.recommended_style

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorani.projectsmilehair.databinding.ItemTitleBinding
import com.gorani.projectsmilehair.model.Title

class RecommendedSectionTitleAdapter: ListAdapter<Title, RecommendedSectionTitleAdapter.RecommendedSectionTitleViewHolder>(TitleDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedSectionTitleViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendedSectionTitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedSectionTitleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecommendedSectionTitleViewHolder(private val binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(title: Title) {
            binding.title = title
            binding.executePendingBindings()

        }
    }
}

class TitleDiffCallback : DiffUtil.ItemCallback<Title>() {
    override fun areItemsTheSame(oldItem: Title, newItem: Title): Boolean {
        return oldItem.text == newItem.text
    }

    override fun areContentsTheSame(oldItem: Title, newItem: Title): Boolean {
        return oldItem == newItem
    }
}