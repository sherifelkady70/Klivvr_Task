package com.route.cities.data

data class PaginatedData<T>(
    val currentPage: Int,
    val pageSize: Int,
    val totalPages: Int,
    var data: List<T>
)