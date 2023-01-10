package com.gorani.projectsmilehair.repository.hairstyledetail

import com.gorani.projectsmilehair.model.HairStyleDetail

class HairStyleDetailRepository(
    private val remoteDataSource: HairStyleDetailRemoteDataSource
) {

    suspend fun getHairStyleDetail(): HairStyleDetail {
        return remoteDataSource.getHairStyleDetail()

// 인터페이스의 인자로 categoryId 를 추가했을경우 이 주석으로 대체
//        return remoteDataSource.getHairStyleDetail(categoryId = "female_perm")
    }
}