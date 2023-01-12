package com.gorani.projectsmilehair.network

import com.gorani.projectsmilehair.model.HairStyleDetail
import com.gorani.projectsmilehair.model.StyleCategory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("style_categories.json")
    suspend fun getStyleCategories(): List<StyleCategory>

    @GET("{categoryId}.json")
    suspend fun getHairStyleDetail(@Path("categoryId") categoryId: String): HairStyleDetail

    companion object {

        private const val baseUrl = "https://smile-cb8a2-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create(): ApiClient {

            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}