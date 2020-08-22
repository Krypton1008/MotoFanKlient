package pl.krypot.motofanmobile.utils

import pl.krypot.motofanmobile.data.NewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ShortBoxApiService {

    @GET("news/getAllNews")
    fun getNew(): Call<NewsResponse>

    companion object Factory {
        const val BASE_URL = "http://192.168.25.81:8080/api/"

        fun create(): ShortBoxApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(this.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ShortBoxApiService::class.java)
        }

    }
}