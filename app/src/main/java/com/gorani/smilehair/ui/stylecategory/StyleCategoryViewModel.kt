package com.gorani.smilehair.ui.stylecategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorani.smilehair.model.StyleCategory
import com.gorani.smilehair.repository.stylecategory.StyleCategoryRepository
import com.gorani.smilehair.ui.common.Event
import kotlinx.coroutines.launch

class StyleCategoryViewModel(
    private val styleCategoryRepository: StyleCategoryRepository
): ViewModel() {

    private val _items = MutableLiveData<List<StyleCategory>>()
    val items: LiveData<List<StyleCategory>> = _items

    private val _openStyleCategoryEvent = MutableLiveData<Event<StyleCategory>>()
    val openStyleCategoryEvent: LiveData<Event<StyleCategory>> = _openStyleCategoryEvent

    init {
        loadStyleCategory()
    }

    fun openHairStyleDetail(styleCategory: StyleCategory) {
        _openStyleCategoryEvent.value = Event(styleCategory)
    }

    private fun loadStyleCategory() {
        viewModelScope.launch {
            val styleCategories = styleCategoryRepository.getStyleCategories()
            _items.value = styleCategories
        }
    }
}