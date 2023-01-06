package com.gorani.projectsmilehair.ui.style_category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorani.projectsmilehair.model.StyleCategory
import com.gorani.projectsmilehair.repository.StyleCategoryRepository
import kotlinx.coroutines.launch

class StyleCategoryViewModel(
    private val styleCategoryRepository: StyleCategoryRepository
): ViewModel() {

    private val _items = MutableLiveData<List<StyleCategory>>()
    val items: LiveData<List<StyleCategory>> = _items

    init {
        loadStyleCategory()
    }

    private fun loadStyleCategory() {
        viewModelScope.launch {
            val styleCategories = styleCategoryRepository.getStyleCategories()
            _items.value = styleCategories
        }
    }
}