package com.gorani.projectsmilehair.repository.hairstyledetail

import com.gorani.projectsmilehair.model.HairStyleDetail
import com.gorani.projectsmilehair.network.ApiClient

class HairStyleDetailRemoteDataSource(private val api: ApiClient): HairStyleDetailDataSource {
    override suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail {
        return api.getHairStyleDetail(categoryId)

    }
}