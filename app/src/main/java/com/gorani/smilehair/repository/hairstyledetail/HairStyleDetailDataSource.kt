package com.gorani.smilehair.repository.hairstyledetail

import com.gorani.smilehair.model.HairStyleDetail

interface HairStyleDetailDataSource {
    suspend fun getHairStyleDetail(categoryId: String): HairStyleDetail

}