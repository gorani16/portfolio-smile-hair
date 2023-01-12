package com.gorani.projectsmilehair.repository.hairstyledetail

import com.gorani.projectsmilehair.model.HairStyleDetail

interface HairStyleDetailDataSource {
    suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail

}