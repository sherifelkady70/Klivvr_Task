package com.route.cities.data.repository

import com.route.cities.data.models.City

interface CitiesRepository {
    suspend fun getCities() : List<City>
}