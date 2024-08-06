package com.route.cities.search

import com.route.cities.search.repository.TrieRepository
import com.route.cities.search.repository.TrieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SearchRepoDi {

    @Provides
    fun provideTrie(impl : TrieRepositoryImpl) : TrieRepository {
        return impl
    }

}