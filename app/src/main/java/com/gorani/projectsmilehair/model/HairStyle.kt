package com.gorani.projectsmilehair.model

import com.google.gson.annotations.SerializedName

data class HairStyle(
    @SerializedName("hair_style_id") val hairStyleId: String,
    val label: String,
    val description: String,
    @SerializedName("hair_style_image_url") val hairStyleImageUrl: String
)
