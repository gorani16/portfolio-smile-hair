package com.gorani.smilehair.repository.home

import com.gorani.smilehair.model.HomeData

class HomeRepository(
    private val assetDataSource: HomeAssetDataSource
) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}