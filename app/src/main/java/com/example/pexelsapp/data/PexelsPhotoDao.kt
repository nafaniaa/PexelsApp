package com.example.pexelsapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PexelsPhotoDao {
    //Внесение новой фотографии в базу данных
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: PexelsPhotoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<PexelsPhotoEntity>)

    @Update
    suspend fun update(photo: PexelsPhotoEntity)

    @Delete
    suspend fun delete(photo: PexelsPhotoEntity)


    @Query("select * from photos where id = :id limit 1")
    suspend fun getById(id : Int): PexelsPhotoEntity


    //Метод deleteById удаляет фотографию с определённым ID
    @Query("delete from photos where id = :id")
    suspend fun deleteById(id: Int)

    //Метод getAll() возращает все фотографии в  виде Flow
    @Query("select * from photos")
    fun getAll(): Flow<List<PexelsPhotoEntity>>

    //Метод для выбора всех понравившихся фотографий
    @Query("select * from photos where isLiked = 1" ) //
     fun getAllLiked(): Flow<List<PexelsPhotoEntity>>

     @Query("delete from photos where isLiked = 0")
     suspend fun deleteUnliked()

    @Query("select count(*) > 0 from photos")
    suspend fun isEmpty(): Boolean
}