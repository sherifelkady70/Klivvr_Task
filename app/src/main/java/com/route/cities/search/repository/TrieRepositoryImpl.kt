package com.route.cities.search.repository

import com.route.cities.data.models.City
import com.route.cities.search.Trie
import com.route.cities.search.TrieInterface
import javax.inject.Inject

class TrieRepositoryImpl {
//    override suspend fun insert(word: String) {
//        trie.insert(word)
//    }
//
//    override suspend fun search(trie1 : Trie, prefix: String,cities: List<City>) : List<City> {
//        val results = mutableListOf<String>()
//        var node = trie1.root
//        for (char in prefix) {
//            node = node.children[char] ?: return emptyList()
//        }
//
//        trie.findWords(node, prefix, results)
//
//        // Filter cities based on complete names
//        return cities.filter { city ->
//            results.contains(city.name)
//        }
//        //return trie1.search(prefix)
//    }
//
//    override suspend fun buildTrie(cities:List<City>) : Trie {
//        val trieObj = Trie()
//            cities.forEach { city ->
//                trieObj.insert(city.name!!)
//            }
//        return trieObj
//    }
}