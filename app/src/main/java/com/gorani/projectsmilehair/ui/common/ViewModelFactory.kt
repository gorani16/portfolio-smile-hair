package com.gorani.projectsmilehair.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gorani.projectsmilehair.AssetLoader
import com.gorani.projectsmilehair.repository.HomeAssetDataSource
import com.gorani.projectsmilehair.repository.HomeRepository
import com.gorani.projectsmilehair.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            return HomeViewModel(repository) as T
        } else {
            throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass::class.java}")
        }

    }
}