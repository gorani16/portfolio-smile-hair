package com.gorani.smilehair.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gorani.smilehair.AssetLoader
import com.gorani.smilehair.network.ApiClient
import com.gorani.smilehair.repository.hairstyledetail.HairStyleDetailRemoteDataSource
import com.gorani.smilehair.repository.hairstyledetail.HairStyleDetailRepository
import com.gorani.smilehair.repository.home.HomeAssetDataSource
import com.gorani.smilehair.repository.home.HomeRepository
import com.gorani.smilehair.repository.stylecategory.StyleCategoryRemoteDataSource
import com.gorani.smilehair.repository.stylecategory.StyleCategoryRepository
import com.gorani.smilehair.ui.hairstyledetail.HairStyleDetailViewModel
import com.gorani.smilehair.ui.home.HomeViewModel
import com.gorani.smilehair.ui.stylecategory.StyleCategoryViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(StyleCategoryViewModel::class.java) -> {
                val repository = StyleCategoryRepository(StyleCategoryRemoteDataSource(ApiClient.create()))
                StyleCategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HairStyleDetailViewModel::class.java) -> {
                val repository = HairStyleDetailRepository(HairStyleDetailRemoteDataSource(ApiClient.create()))
                HairStyleDetailViewModel(repository) as T
            }
            else -> {
                throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass::class.java}")
            }
        }
    }
}

