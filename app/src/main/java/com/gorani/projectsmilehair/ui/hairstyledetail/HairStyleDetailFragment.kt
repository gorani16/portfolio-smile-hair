package com.gorani.projectsmilehair.ui.hairstyledetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.gorani.projectsmilehair.common.KEY_STYLE_CATEGORY_ID
import com.gorani.projectsmilehair.common.KEY_STYLE_CATEGORY_LABEL
import com.gorani.projectsmilehair.databinding.FragmentHairStyleDetailBinding
import com.gorani.projectsmilehair.ui.common.ViewModelFactory

class HairStyleDetailFragment: Fragment() {

    private lateinit var binding: FragmentHairStyleDetailBinding
    private val viewModel: HairStyleDetailViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHairStyleDetailBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()

        val categoryId = requireArguments().getString(KEY_STYLE_CATEGORY_ID)
        viewModel.loadHairStyleDetail(categoryId.toString())

    }

    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_STYLE_CATEGORY_LABEL)
        binding.toolbarRecommendedStyle.title = categoryLabel

    }

    private fun setListAdapter() {
        val titleAdapter = RecommendedSectionTitleAdapter()
        val recommendedStyleAdapter = RecommendedStyleAdapter()
        binding.rvRecommendedStyle.adapter = ConcatAdapter(titleAdapter, recommendedStyleAdapter)
        viewModel.titleSection.observe(viewLifecycleOwner) { titleSection ->
            titleAdapter.submitList(listOf(titleSection.title))
        }
        viewModel.recommendedStyles.observe(viewLifecycleOwner) { recommendedStyles ->
            recommendedStyleAdapter.submitList(recommendedStyles.items)
        }

    }
}