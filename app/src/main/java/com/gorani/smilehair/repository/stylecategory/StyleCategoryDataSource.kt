package com.gorani.smilehair.repository.stylecategory

import com.gorani.smilehair.model.StyleCategory

interface StyleCategoryDataSource {

    suspend fun getStyleCategories(): List<StyleCategory>
}