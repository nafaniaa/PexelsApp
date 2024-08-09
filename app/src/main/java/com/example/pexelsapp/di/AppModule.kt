package com.example.pexelsapp.di

import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.local.database.AppDatabase
import com.example.pexelsapp.data.remote.AuthInterceptor
import com.example.pexelsapp.data.remote.PexelsApi
import com.example.pexelsapp.data.repositories.PhotoRepository
import com.example.pexelsapp.data.repositories.PhotoRepositoryImpl
import com.example.pexelsapp.domain.usecases.DeletePhotoUseCase
import com.example.pexelsapp.domain.usecases.GetAllPhotosUseCase
import com.example.pexelsapp.domain.usecases.GetPhotoByIdUseCase
import com.example.pexelsapp.domain.usecases.InsertPhotoUseCase
import com.example.pexelsapp.domain.usecases.UpdatePhotoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providePexelsApi(okHttpClient: OkHttpClient): PexelsApi {
        return Retrofit.Builder()
            .baseUrl("https://api.pexels.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PexelsApi::class.java)
    }


    @Provides
    @Singleton
    fun providePhotoRepository(photoDao: PhotoDao, pexelsApi: PexelsApi): PhotoRepository {
        return PhotoRepositoryImpl(photoDao, pexelsApi)
    }

    @Provides
    @Singleton
    fun provideInsertPhotoUseCase(repository: PhotoRepository): InsertPhotoUseCase {
        return InsertPhotoUseCase(repository)
    }


    @Provides
    @Singleton
    fun provideUpdatePhotoUseCase(repository: PhotoRepository): UpdatePhotoUseCase {
        return UpdatePhotoUseCase(repository)
    }


    @Provides
    @Singleton
    fun provideDeletePhotoUseCase(repository: PhotoRepository): DeletePhotoUseCase {
        return DeletePhotoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllPhotosUseCase(repository: PhotoRepository): GetAllPhotosUseCase {
        return GetAllPhotosUseCase(repository)
    }


    @Provides
    @Singleton
    fun provideGetPhotoByIdUseCase(repository: PhotoRepository): GetPhotoByIdUseCase {
        return GetPhotoByIdUseCase(repository)
    }
}