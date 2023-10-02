package com.example.android.hilt.di

import android.app.Activity
import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.LoggerInMemoryDataSource
import com.example.android.hilt.data.LoggerLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class LoggingModule {

    @Singleton
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource): LoggerDataSource
}

@InstallIn(ActivityComponent::class)
@Module
abstract class LoggingInMemoryModule {
    @ActivityScoped
    @Binds
    abstract fun bindInMemoryLogger(impl: LoggerInMemoryDataSource): LoggerDataSource
}
