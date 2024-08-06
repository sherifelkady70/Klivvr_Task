package com.route.cities.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.cities.data.contract.CitiesRepositoryInterface
import com.route.cities.data.models.City
import com.route.cities.search.repository.TrieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val citiesRepo : CitiesRepositoryInterface,
    private val trieRepo : TrieRepository
): ViewModel() {
    val state = mutableStateOf<List<City>>(listOf())
    private val _search = MutableStateFlow("")
    val searchQuery : StateFlow<String> = _search.asStateFlow()


    private val _filteredList = MutableStateFlow<List<City>>(emptyList())
    val filteredList : StateFlow<List<City>> = _filteredList.asStateFlow()

    init {
        getData()
    }
    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val cities = citiesRepo.getCities()
            withContext(Dispatchers.Main){
                state.value = cities
               // filteredList.value = cities
            }
        }
    }


}

