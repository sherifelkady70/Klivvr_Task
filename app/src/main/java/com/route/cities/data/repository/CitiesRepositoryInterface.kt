package com.route.cities.data.repository

import com.route.cities.data.models.City

interface CitiesRepositoryInterface {
    suspend fun getCities() : List<City>
}