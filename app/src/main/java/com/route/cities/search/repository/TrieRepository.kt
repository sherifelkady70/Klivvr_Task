package com.route.cities.search.repository

interface TrieRepository {
    suspend fun insert(word:String)
    suspend fun search(prefix:String) : List<String>
}