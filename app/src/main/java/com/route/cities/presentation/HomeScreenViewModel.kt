package com.route.cities.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.cities.data.PaginatedData
import com.route.cities.data.contract.CitiesRepositoryInterface
import com.route.cities.data.models.City
import com.route.cities.search.Trie
import com.route.cities.search.TrieNode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val citiesRepo : CitiesRepositoryInterface,
): ViewModel() {
    val root = TrieNode()
    //val state = mutableStateOf<List<City>>(listOf())

    private val _currentPage = MutableStateFlow(1)
    val currentPage: StateFlow<Int> = _currentPage

    private val _cities = MutableStateFlow<PaginatedData<City>>(PaginatedData(1, 20, 0, emptyList())) // Replace 20 with your desired page size
    val cities: StateFlow<PaginatedData<City>> = _cities

    private lateinit var allCities: List<City>


    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    var trie: Trie = Trie()

     private val _filteredList = MutableStateFlow<List<City>>(emptyList())
    val filteredList: StateFlow<List<City>> = _filteredList.asStateFlow()

    init {
        getData()
    }
    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            allCities= citiesRepo.getCities()
            trie = buildTrie(allCities)
            withContext(Dispatchers.Main){
                val initialData = citiesRepo.getCitiesForPage(1)
                _cities.value = initialData

                Log.d("TAG","state.value = ${_cities.value}")
            }

        }
    }
    fun searchAlgorithm(searchText:String){
        _searchQuery.value = searchText
        Log.d("TAG","searchQuery = ${_searchQuery.value}")
       viewModelScope.launch {
           Log.d("TAG","in getData() in view model${trie}")
           searchQuery.collectLatest { query ->
               Log.d("TAG","searchQuery = ${searchQuery.value}")
               val results = searchCities(trie, query)
               Log.d("TAG","query = ${query}")
               Log.d("TAG","results = ${results}")
               _filteredList.value = results
               Log.d("TAG","results = ${_filteredList.value}")
           }
        }
    }
    private fun buildTrie(cities: List<City>): Trie {
//        val trie = Trie()
        cities.forEach { city ->
            trie.insert(city.name!!)
        }
        return trie
    }
    private fun searchCities(trie: Trie, query: String): List<City> {
        val results = mutableListOf<String>()
        var node = trie.root
        // traverse the Trie based on the query
        for (char in query) {
            node = node.children[char] ?: return emptyList()
        }
        // find all possible words starting with the query
        trie.findWords(node, query, results)
        // filter cities based on complete names and return the corresponding City objects
        return _cities.value.data.filter { city ->
            results.contains(city.name)
        }
    }

    fun loadNextPage() {
        viewModelScope.launch {
            val currentPageValue = currentPage.value
            val nextPageData = citiesRepo.getCitiesForPage(currentPageValue + 1)
            _cities.update { currentData ->
                currentData.copy(
                    currentPage = nextPageData.currentPage,
                    totalPages = nextPageData.totalPages,
                    data = currentData.data + nextPageData.data
                )
            }
        }
    }
}

