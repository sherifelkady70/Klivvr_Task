package com.route.cities.search.repository

import com.route.cities.search.Trie
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val trie: Trie
): SearchRepository {
    override suspend fun insert(word: String) {
        trie.insert(word)
    }

    override suspend fun search(prefix: String) : List<String> {
        return trie.search(prefix)
    }
}