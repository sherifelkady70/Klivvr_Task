package com.route.cities.data

data class PaginatedData<T>(
    val currentPage: Int,
    val pageSize: Int,
    val totalPages: Int,
    val data: List<T>
)