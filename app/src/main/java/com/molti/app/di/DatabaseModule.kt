package com.molti.app.di

import android.content.Context
import androidx.room.Room
import com.molti.app.data.local.MoltiDatabase
import com.molti.app.data.local.dao.ChatDao
import com.molti.app.data.local.dao.TaskDao
import com.molti.app.data.local.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MoltiDatabase {
        return Room.databaseBuilder(
            context,
            MoltiDatabase::class.java,
            "molti_database"
        ).build()
    }
    
    @Provides
    fun provideChatDao(database: MoltiDatabase): ChatDao {
        return database.chatDao()
    }
    
    @Provides
    fun provideTaskDao(database: MoltiDatabase): TaskDao {
        return database.taskDao()
    }
    
    @Provides
    fun provideNoteDao(database: MoltiDatabase): NoteDao {
        return database.noteDao()
    }
}
