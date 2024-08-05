package com.route.cities.data

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
object DataModule {
    @Provides
    fun provideCitiesDataManager(impl : CitiesDataManager) : CitiesDataManagerInterface {
        return
    }
}