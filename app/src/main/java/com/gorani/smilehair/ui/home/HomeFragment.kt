package com.gorani.smilehair.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.gorani.smilehair.*
import com.gorani.smilehair.common.KEY_STYLE_CATEGORY_ID
import com.gorani.smilehair.common.KEY_STYLE_CATEGORY_LABEL
import com.gorani.smilehair.databinding.FragmentHomeBinding
import com.gorani.smilehair.ui.common.EventObserver
import com.gorani.smilehair.ui.common.ViewModelFactory
import com.gorani.smilehair.ui.stylecategory.StyleCategoryAdapter
import com.gorani.smilehair.ui.stylecategory.StyleCategoryViewModel

class HomeFragment: Fragment() {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private val styleCategoryViewModel: StyleCategoryViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val styleCategoryAdapter = StyleCategoryAdapter(styleCategoryViewModel)
        binding.rvStyleCategoryList.adapter = styleCategoryAdapter
        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setTopBanners()

        styleCategoryViewModel.items.observe(viewLifecycleOwner) {
            styleCategoryAdapter.submitList(it)
        }

        styleCategoryViewModel.openStyleCategoryEvent.observe(viewLifecycleOwner, EventObserver {
            openHairStyleDetail(it.categoryId, it.label)
        })
    }

    private fun openHairStyleDetail(categoryId: String, categoryLabel: String) {
        findNavController().navigate(R.id.action_home_to_hair_style, bundleOf(
            KEY_STYLE_CATEGORY_ID to categoryId,
            KEY_STYLE_CATEGORY_LABEL to categoryLabel
        ))
    }

    private fun setToolbar() {
        viewModel.title.observe(viewLifecycleOwner) { title ->
            binding.title = title
        }
    }

    private fun setTopBanners() {
        with(binding.viewpagerHomeBanner) {
            adapter = HomeBannerAdapter().apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }
            TabLayoutMediator(binding.viewpagerHomeBannerIndicator, this) { _, _ -> }.attach()
        }
    }
}