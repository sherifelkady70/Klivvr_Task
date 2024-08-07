package com.route.cities.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val citiesRepo : CitiesRepositoryInterface,
): ViewModel() {
    val root = TrieNode()
    val state = mutableStateOf<List<City>>(listOf())

     private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

//    private val _cities = MutableStateFlow<List<City>>(emptyList())
//    val cities: StateFlow<List<City>> = _cities.asStateFlow()

    private lateinit var trie: Trie


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
//                _filteredList.value = cities
            }
        }
    }
    fun searchAlgorithm(w:String){
        _searchQuery.value = w
       viewModelScope.launch {
           trie = buildTrie(state.value)
           searchQuery.collectLatest { query ->
               val results = searchCities(trie, query)
               _filteredList.value = results
           }
        }
    }
    private fun buildTrie(cities: List<City>): Trie {
        val trie = Trie()
        cities.forEach { city ->
            trie.insert(city.name!!)
        }
        return trie
    }

    private fun searchCities(trie: Trie, query: String): List<City> {
        val results = mutableListOf<String>()
        var node = trie.root

        // Traverse the Trie based on the query
        for (char in query) {
            node = node.children[char] ?: return emptyList()
        }

        // Find all possible words starting with the query
        trie.findWords(node, query, results)

        // Filter cities based on complete names and return the corresponding City objects
        return state.value.filter { city ->
            results.contains(city.name)
        }
    }
}

