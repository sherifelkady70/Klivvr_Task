package com.route.cities.data.data_manager

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.route.cities.data.contract.CitiesDataManagerInterface
import com.route.cities.data.models.City
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class CitiesDataManagerImpl @Inject constructor(
    private val context: Context
) : CitiesDataManagerInterface {
    override suspend fun getCities() : List<City>{
        val assetManager : AssetManager = context.assets
        val inputStream = assetManager.open("cities.json")
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        val jsonString = bufferReader.use { it.readText() }
        val cityTypeList = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson(jsonString,cityTypeList)
    }
}