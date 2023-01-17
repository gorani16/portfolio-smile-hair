package com.gorani.smilehair.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    @SerializedName("banner_id") val bannerId: String
)
