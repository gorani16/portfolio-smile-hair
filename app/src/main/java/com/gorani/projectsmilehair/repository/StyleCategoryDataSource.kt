package com.gorani.projectsmilehair.repository

import com.gorani.projectsmilehair.model.StyleCategory

interface StyleCategoryDataSource {

    suspend fun getStyleCategories(): List<StyleCategory>
}