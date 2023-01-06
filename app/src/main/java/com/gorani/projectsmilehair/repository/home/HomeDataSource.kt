package com.gorani.projectsmilehair.repository.home

import com.gorani.projectsmilehair.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}