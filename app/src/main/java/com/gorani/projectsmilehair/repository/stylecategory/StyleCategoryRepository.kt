package com.gorani.projectsmilehair.repository.stylecategory

import com.gorani.projectsmilehair.model.StyleCategory

class StyleCategoryRepository(
    private val remoteDataSource: StyleCategoryRemoteDataSource
) {

    suspend fun getStyleCategories(): List<StyleCategory> {
        return remoteDataSource.getStyleCategories()
    }
}