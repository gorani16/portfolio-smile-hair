package com.gorani.projectsmilehair.repository

import com.gorani.projectsmilehair.model.StyleCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StyleCategoryRepository(
    private val remoteDataSource: StyleCategoryRemoteDataSource
) {

    suspend fun getStyleCategories(): List<StyleCategory> {
        return remoteDataSource.getStyleCategories()
    }
}