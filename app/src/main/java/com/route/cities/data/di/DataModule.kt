package com.route.cities.data.di

import com.route.cities.data.data_manager.CitiesDataManagerImpl
import com.route.cities.data.contract.CitiesDataManagerInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 object DataModule {
    @Provides
     fun provideCitiesDataManager(impl : CitiesDataManagerImpl)
    : CitiesDataManagerInterface {
         return impl
     }
}