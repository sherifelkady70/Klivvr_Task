package com.route.cities.data.contract

import com.route.cities.data.models.City

interface CitiesRepositoryInterface {
    suspend fun getCities() : List<City>
}