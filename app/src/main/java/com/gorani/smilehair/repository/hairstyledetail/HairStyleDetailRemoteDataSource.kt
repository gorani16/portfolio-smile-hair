package com.gorani.smilehair.repository.hairstyledetail

import com.gorani.smilehair.model.HairStyleDetail
import com.gorani.smilehair.network.ApiClient

class HairStyleDetailRemoteDataSource(private val api: ApiClient): HairStyleDetailDataSource {
    override suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail {
        return api.getHairStyleDetail(categoryId)

    }
}