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

// This file defines the main dependency injection module for the application
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // This method provides an instance of AuthInterceptor, which is used to
    // add authentication headers to the HTTP requests
    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }

    // This method provides an instance of OkHttpClient, which is configured
    // with the AuthInterceptor
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    // This method provides an instance of PexelsApi, which is configured
    // with the OkHttpClient and the Retrofit library
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

    // This method provides an instance of PhotoRepository, which is implemented
    // by the PhotoRepositoryImpl class
    @Provides
    @Singleton
    fun providePhotoRepository(photoDao: PhotoDao, pexelsApi: PexelsApi): PhotoRepository {
        return PhotoRepositoryImpl(photoDao, pexelsApi)
    }

    // This method provides an instance of InsertPhotoUseCase, which is used
    // to insert a new PhotoModel into the repository
    @Provides
    @Singleton
    fun provideInsertPhotoUseCase(repository: PhotoRepository): InsertPhotoUseCase {
        return InsertPhotoUseCase(repository)
    }

    // This method provides an instance of UpdatePhotoUseCase, which is used
    // to update an existing PhotoModel in the repository
    @Provides
    @Singleton
    fun provideUpdatePhotoUseCase(repository: PhotoRepository): UpdatePhotoUseCase {
        return UpdatePhotoUseCase(repository)
    }

    // This method provides an instance of DeletePhotoUseCase, which is used
    // to delete a PhotoModel from the repository
    @Provides
    @Singleton
    fun provideDeletePhotoUseCase(repository: PhotoRepository): DeletePhotoUseCase {
        return DeletePhotoUseCase(repository)
    }

    // This method provides an instance of GetAllPhotosUseCase, which is used
    // to retrieve all PhotoModel objects from the repository
    @Provides
    @Singleton
    fun provideGetAllPhotosUseCase(repository: PhotoRepository): GetAllPhotosUseCase {
        return GetAllPhotosUseCase(repository)
    }

    // This method provides an instance of GetPhotoByIdUseCase, which is used
    // to retrieve a single PhotoModel object from the repository by its ID
    @Provides
    @Singleton
    fun provideGetPhotoByIdUseCase(repository: PhotoRepository): GetPhotoByIdUseCase {
        return GetPhotoByIdUseCase(repository)
    }
}