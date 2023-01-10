package com.gorani.projectsmilehair.repository.stylecategory

import com.gorani.projectsmilehair.model.StyleCategory
import com.gorani.projectsmilehair.network.ApiClient

class StyleCategoryRemoteDataSource(private val apiClient: ApiClient): StyleCategoryDataSource {

    override suspend fun getStyleCategories(): List<StyleCategory> {
        return apiClient.getStyleCategories()
    }
}