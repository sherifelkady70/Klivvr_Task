package com.route.cities.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.cities.data.contract.CitiesRepositoryInterface
import com.route.cities.data.models.City
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val citiesRepo : CitiesRepositoryInterface
): ViewModel() {
    val state = mutableStateOf<List<City>>(listOf())
    var filteredList = mutableStateOf<List<City>>(listOf())
    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val cities = citiesRepo.getCities()
            withContext(Dispatchers.Main){
                state.value = cities
               // filteredList.value = cities
            }
        }
    }

//    fun searchAlgorithm(value : String){
//    }


}

