package com.gorani.projectsmilehair.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gorani.projectsmilehair.AssetLoader
import com.gorani.projectsmilehair.network.ApiClient
import com.gorani.projectsmilehair.repository.*
import com.gorani.projectsmilehair.ui.home.HomeViewModel
import com.gorani.projectsmilehair.ui.style_category.StyleCategoryViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(StyleCategoryViewModel::class.java)) {
            val repository = StyleCategoryRepository(StyleCategoryRemoteDataSource(ApiClient.create()))
            StyleCategoryViewModel(repository) as T
        } else {
            throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass::class.java}")
        }

    }
}