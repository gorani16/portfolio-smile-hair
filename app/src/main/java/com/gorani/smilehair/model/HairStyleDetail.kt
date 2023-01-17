package com.gorani.smilehair.model

import com.google.gson.annotations.SerializedName

data class HairStyleDetail(
    @SerializedName("title_section")val titleSection: TitleSection,
    @SerializedName("recommended_styles") val recommendedStyles: RecommendedStyle
)

data class TitleSection(
    val title: Title
)

data class RecommendedStyle(
    val items: List<HairStyle>
)

