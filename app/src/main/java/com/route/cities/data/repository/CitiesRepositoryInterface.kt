package com.route.cities.data.repository

import com.route.cities.data.CitiesDataManager
import com.route.cities.data.models.City
import javax.inject.Inject

class CitiesRepositoryInterface @Inject constructor(
    private val citiesDataManager: CitiesDataManager
): CitiesRepository {
    override suspend fun getCities(): List<City> {
        return citiesDataManager.getCities()
    }
}