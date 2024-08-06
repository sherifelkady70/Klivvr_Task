package com.route.cities.search

data class TrieNode(
    val children : MutableMap<Char, TrieNode> = mutableMapOf(),
    var isEndOfWord : Boolean = false
)
