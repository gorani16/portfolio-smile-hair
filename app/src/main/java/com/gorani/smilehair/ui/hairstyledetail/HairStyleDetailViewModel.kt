package com.gorani.smilehair.ui.hairstyledetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorani.smilehair.model.RecommendedStyle
import com.gorani.smilehair.model.TitleSection
import com.gorani.smilehair.repository.hairstyledetail.HairStyleDetailRepository
import kotlinx.coroutines.launch

class HairStyleDetailViewModel(
    private val hairStyleDetailRepository: HairStyleDetailRepository
): ViewModel() {

    private val _titleSection = MutableLiveData<TitleSection>()
    val titleSection: LiveData<TitleSection> = _titleSection

    private val _recommendedStyles = MutableLiveData<RecommendedStyle>()
    val recommendedStyles: LiveData<RecommendedStyle> = _recommendedStyles

    fun loadHairStyleDetail(categoryId: String) {
        viewModelScope.launch {
            val hairStyleDetail = hairStyleDetailRepository.getHairStyleDetail(categoryId)
            _titleSection.value = hairStyleDetail.titleSection
            _recommendedStyles.value = hairStyleDetail.recommendedStyles
        }
    }
}