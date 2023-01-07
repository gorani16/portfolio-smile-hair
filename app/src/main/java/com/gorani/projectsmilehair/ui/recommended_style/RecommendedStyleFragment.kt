package com.gorani.projectsmilehair.ui.recommended_style

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gorani.projectsmilehair.common.KEY_STYLE_CATEGORY_ID
import com.gorani.projectsmilehair.common.KEY_STYLE_CATEGORY_LABEL
import com.gorani.projectsmilehair.databinding.FragmentRecommendedStyleBinding

class RecommendedStyleFragment: Fragment() {

    private lateinit var binding: FragmentRecommendedStyleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendedStyleBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        val categoryId = requireArguments().getString(KEY_STYLE_CATEGORY_ID)
        val categoryLabel = requireArguments().getString(KEY_STYLE_CATEGORY_LABEL)
        binding.toolbarRecommendedStyle.title = categoryLabel

    }
}