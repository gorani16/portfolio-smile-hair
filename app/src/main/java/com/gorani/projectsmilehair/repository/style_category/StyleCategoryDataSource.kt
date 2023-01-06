package com.gorani.projectsmilehair.repository.style_category

import com.gorani.projectsmilehair.model.StyleCategory

interface StyleCategoryDataSource {

    suspend fun getStyleCategories(): List<StyleCategory>
}