package com.gorani.projectsmilehair.ui.hairstyledetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorani.projectsmilehair.model.RecommendedStyle
import com.gorani.projectsmilehair.model.TitleSection
import com.gorani.projectsmilehair.repository.hairstyledetail.HairStyleDetailRepository
import kotlinx.coroutines.launch

class HairStyleDetailViewModel(
    private val hairStyleDetailRepository: HairStyleDetailRepository
): ViewModel() {

    private val _titleSection = MutableLiveData<TitleSection>()
    val titleSection: LiveData<TitleSection> = _titleSection

    private val _recommendedStyles = MutableLiveData<RecommendedStyle>()
    val recommendedStyles: LiveData<RecommendedStyle> = _recommendedStyles

    init {
        loadHairStyleDetail()
    }

    private fun loadHairStyleDetail() {
        viewModelScope.launch {
            val hairStyleDetail = hairStyleDetailRepository.getHairStyleDetail()
            _titleSection.value = hairStyleDetail.titleSection
            _recommendedStyles.value = hairStyleDetail.recommendedStyles
        }
    }


}