package com.example.pexelsapp.network

import android.content.Context
import com.example.pexelsapp.R
import com.example.pexelsapp.data.NetworkPhotosRepository
import com.example.pexelsapp.data.PhotosRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface PexelsAppContainer{
    val photosRepository : PhotosRepository
}
@ViewModelScoped
class PexelsApiClient @Inject constructor(
    @ApplicationContext private val context: Context
) : PexelsAppContainer{

    companion object {
        private const val BASE_URL = "https://api.pexels.com/v1/"
    }

    private val apiKeyInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", context.getString(R.string.pexels_api_key))
            .build()
        chain.proceed(request)
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(apiKeyInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val pexelsApi: PexelsApi by lazy {
        retrofit.create(PexelsApi::class.java)
    }

    override val photosRepository: PhotosRepository by lazy {
        NetworkPhotosRepository(pexelsApi)
    }
}
