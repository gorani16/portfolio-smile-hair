package com.gorani.smilehair.repository.home

import com.google.gson.Gson
import com.gorani.smilehair.AssetLoader
import com.gorani.smilehair.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}