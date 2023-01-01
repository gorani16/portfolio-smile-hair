package com.gorani.projectsmilehair.repository

import com.google.gson.Gson
import com.gorani.projectsmilehair.AssetLoader
import com.gorani.projectsmilehair.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}