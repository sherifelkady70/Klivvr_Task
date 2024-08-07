package com.route.cities.search

class Trie {
    val root = TrieNode()
      fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.isEndOfWord = true
    }
    fun findWords(node: TrieNode, prefix: String, results: MutableList<String>) {
        if (node.isEndOfWord) {
            results.add(prefix)
        }
        for ((char, child) in node.children) {
            findWords(child, prefix + char, results)
        }
    }

}