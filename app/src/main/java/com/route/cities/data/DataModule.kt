package com.route.cities.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
abstract class DataModule {
    @Binds
    abstract fun provideCitiesDataManager(impl : CitiesDataManager)
    : CitiesDataManagerInterface
}