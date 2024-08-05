package com.route.cities.data.repository

import com.route.cities.data.data_manager.CitiesDataManagerImpl
import com.route.cities.data.contract.CitiesRepositoryInterface
import com.route.cities.data.models.City
import javax.inject.Inject

class CitiesRepositoryImpl @Inject constructor(
    private val citiesDataManager: CitiesDataManagerImpl
): CitiesRepositoryInterface {
    override suspend fun getCities(): List<City> {
        return citiesDataManager.getCities()
    }
}