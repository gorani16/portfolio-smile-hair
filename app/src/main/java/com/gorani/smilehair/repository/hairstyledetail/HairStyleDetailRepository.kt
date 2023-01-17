package com.gorani.smilehair.repository.hairstyledetail

import com.gorani.smilehair.model.HairStyleDetail

class HairStyleDetailRepository(
    private val remoteDataSource: HairStyleDetailRemoteDataSource
) {
    suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail {
        return remoteDataSource.getHairStyleDetail(categoryId)

    }
}