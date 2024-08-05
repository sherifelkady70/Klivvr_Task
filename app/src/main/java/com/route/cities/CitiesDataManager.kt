package com.route.cities

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.route.cities.models.City
import java.io.BufferedReader
import java.io.InputStreamReader

class CitiesDataManager(private val context: Context) {
    fun getCities() : List<City>{
        val assetManager : AssetManager = context.assets
        val inputStream = assetManager.open("cities.json")
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        val jsonString = bufferReader.use { it.readText() }
        val cityTypeList = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson(jsonString,cityTypeList)
    }
}