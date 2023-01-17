package com.gorani.smilehair.model

import com.google.gson.annotations.SerializedName

data class StyleCategory(
    @SerializedName("category_id") val categoryId: String,
    val label: String,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String
)
