package com.example.pexelsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
entities = [PexelsPhotoEntity::class],
    version = 6
)
abstract class PexelsPhotoDatabase : RoomDatabase() {
    abstract fun pexelsPhotoDao() : PexelsPhotoDao

    companion object {

        //Для избежания проблем с потоковой видимостью
        @Volatile
        private var INSTANCE: PexelsPhotoDatabase? = null

        //Функция, возвращающая экземпляр базы данных.
        fun instance(context: Context): PexelsPhotoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PexelsPhotoDatabase::class.java,
                    "pexels_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}