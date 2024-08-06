package com.route.cities.search

class Trie {

    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.isEndOfWord = true
    }

    fun search(prefix: String): List<String> {
        val results = mutableListOf<String>()
        var node = root
        for (char in prefix) {
            node = node.children[char] ?: return emptyList()
        }
        findWords(node, prefix, results)
        return results
    }

    private fun findWords(node: TrieNode, prefix: String, results: MutableList<String>) {
        if (node.isEndOfWord) {
            results.add(prefix)
        }
        for ((char, child) in node.children) {
            findWords(child, prefix + char, results)
        }
    }

}