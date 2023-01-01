package com.gorani.projectsmilehair.repository

import com.gorani.projectsmilehair.model.HomeData

class HomeRepository(
    private val assetDataSource: HomeAssetDataSource
) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}