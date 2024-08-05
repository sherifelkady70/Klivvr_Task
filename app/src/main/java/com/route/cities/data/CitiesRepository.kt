package com.route.cities.data

import com.route.cities.data.models.City

interface CitiesRepository {
    suspend fun getCities() : List<City>
}