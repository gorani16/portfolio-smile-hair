package com.gorani.smilehair.repository.home

import com.gorani.smilehair.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}