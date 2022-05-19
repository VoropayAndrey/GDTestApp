package com.hardway.gdtest.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.repositories.*
import com.hardway.gdtest.repositories.network.RandomUserService
import com.hardway.gdtest.repositories.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) : SharedPreferences {
        return context.getSharedPreferences(Constants.SavedData.SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideSettingsRepository(sharedPreferences: SharedPreferences) : SettingsRepositoryInterface {
        return SettingsRepositoryImplementation(sharedPreferences)
    }

    @Provides
    fun provideLocalRepository(@ApplicationContext context: Context,
                               settingsRepository: SettingsRepositoryInterface,
                               appDatabase: AppDatabase): LocalRepositoryInterface {
        return LocalRepositoryImplementation(context,
            settingsRepository,
            appDatabase)
    }

    @Provides
    fun provideRemoteRepository(@ApplicationContext context: Context,
                                settingsRepository: SettingsRepositoryInterface,
                                randomUserService: RandomUserService): RemoteRepositoryInterface {
        return RemoteRepositoryImplementation(context,
            settingsRepository,
            randomUserService)
    }
}