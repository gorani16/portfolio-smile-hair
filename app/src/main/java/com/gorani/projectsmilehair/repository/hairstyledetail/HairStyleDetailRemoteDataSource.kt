package com.gorani.projectsmilehair.repository.hairstyledetail

import com.gorani.projectsmilehair.model.HairStyleDetail
import com.gorani.projectsmilehair.network.ApiClient

class HairStyleDetailRemoteDataSource(private val api: ApiClient): HairStyleDetailDataSource {

    override suspend fun getHairStyleDetail(): HairStyleDetail {

        return api.getHairStyleDetail(categoryId = "female_dyeing")
    }

// 인터페이스의 인자로 categoryId 를 추가했을경우 이 주석으로 대체
//    override suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail {
//
//        return api.getHairStyleDetail(categoryId = "female_dyeing")
//    }

}