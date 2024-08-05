package com.route.cities.data.di

import com.route.cities.data.repository.CitiesRepositoryImpl
import com.route.cities.data.contract.CitiesRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 object RepoModule {

    @Provides
     fun provideCitiesRepository(impl : CitiesRepositoryImpl) : CitiesRepositoryInterface {
         return impl
     }
}