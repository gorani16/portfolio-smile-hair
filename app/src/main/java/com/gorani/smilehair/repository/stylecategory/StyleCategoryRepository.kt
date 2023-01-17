package com.gorani.smilehair.repository.stylecategory

import com.gorani.smilehair.model.StyleCategory

class StyleCategoryRepository(
    private val remoteDataSource: StyleCategoryRemoteDataSource
) {

    suspend fun getStyleCategories(): List<StyleCategory> {
        return remoteDataSource.getStyleCategories()
    }
}