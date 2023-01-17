package com.gorani.smilehair.repository.stylecategory

import com.gorani.smilehair.model.StyleCategory
import com.gorani.smilehair.network.ApiClient

class StyleCategoryRemoteDataSource(private val apiClient: ApiClient): StyleCategoryDataSource {

    override suspend fun getStyleCategories(): List<StyleCategory> {
        return apiClient.getStyleCategories()
    }
}