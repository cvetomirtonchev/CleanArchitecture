package com.tsvetomir.tonchev.breakingbad.data.networking.datasource.remote

import com.tsvetomir.tonchev.breakingbad.data.networking.datasource.RemoteDataSource
import com.tsvetomir.tonchev.breakingbad.data.networking.services.CharacterService

class CharactersDataSource : RemoteDataSource() {

    private val service: CharacterService by lazy {
        baseRetrofitClient.createService(CharacterService::class.java)
    }

    fun getAllCharacters(category: String) = getResponseBody(service.getAllCharacters(category))
}