package com.gorani.projectsmilehair.model

import com.google.gson.annotations.SerializedName

data class RecommendedStyle(
    @SerializedName("hair_style_id") val hairStyleId: String,
    val label: String,
    val description: String,
    @SerializedName("recommended_style_image_url") val recommendedStyleImageUrl: String
)
