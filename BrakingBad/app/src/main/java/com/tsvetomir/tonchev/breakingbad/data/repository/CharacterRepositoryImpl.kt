package com.tsvetomir.tonchev.breakingbad.data.repository

import com.tsvetomir.tonchev.breakingbad.data.models.remote.CharacterResponse
import com.tsvetomir.tonchev.breakingbad.data.networking.client.ApiResponse
import com.tsvetomir.tonchev.breakingbad.data.networking.datasource.remote.CharactersDataSource
import okhttp3.ResponseBody

object CharacterRepositoryImpl : CharacterRepository {
    private val dataSource: CharactersDataSource by lazy {
        CharactersDataSource()
    }

    override suspend fun getAllCharacters(category: String): ApiResponse<List<CharacterResponse>> {
        return dataSource.getAllCharacters(category)
    }
}