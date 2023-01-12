package com.gorani.projectsmilehair.repository.hairstyledetail

import com.gorani.projectsmilehair.model.HairStyleDetail

class HairStyleDetailRepository(
    private val remoteDataSource: HairStyleDetailRemoteDataSource
) {
    suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail {
        return remoteDataSource.getHairStyleDetail(categoryId)

    }
}