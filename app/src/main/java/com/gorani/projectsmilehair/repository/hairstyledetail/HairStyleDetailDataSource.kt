package com.gorani.projectsmilehair.repository.hairstyledetail

import com.gorani.projectsmilehair.model.HairStyleDetail

interface HairStyleDetailDataSource {

    suspend fun getHairStyleDetail(): HairStyleDetail

// 인터페이스의 인자로 categoryId 를 추가했을경우 이 주석으로 대체
//    suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail

}