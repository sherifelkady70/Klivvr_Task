package com.route.cities.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object DataModule {
    @Provides
     fun provideCitiesDataManager(impl : CitiesDataManager)
    : CitiesDataManagerInterface {
         return impl
     }
}