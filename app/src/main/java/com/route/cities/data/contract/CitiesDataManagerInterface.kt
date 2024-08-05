package com.route.cities.data.contract

import com.route.cities.data.models.City

interface CitiesDataManagerInterface {
    suspend fun getCities() : List<City>
}