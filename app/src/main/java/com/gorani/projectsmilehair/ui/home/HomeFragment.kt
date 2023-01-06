package com.gorani.projectsmilehair.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.gorani.projectsmilehair.*
import com.gorani.projectsmilehair.databinding.FragmentHomeBinding
import com.gorani.projectsmilehair.ui.common.ViewModelFactory
import com.gorani.projectsmilehair.ui.style_category.StyleCategoryAdapter
import com.gorani.projectsmilehair.ui.style_category.StyleCategoryViewModel

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

        val styleCategoryAdapter = StyleCategoryAdapter()
        binding.rvStyleCategoryList.adapter = styleCategoryAdapter
        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setTopBanners()

        styleCategoryViewModel.items.observe(viewLifecycleOwner) {
            styleCategoryAdapter.submitList(it)
        }
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