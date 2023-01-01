package com.gorani.projectsmilehair.repository

import com.gorani.projectsmilehair.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}