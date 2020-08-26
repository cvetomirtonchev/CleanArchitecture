package com.tsvetomir.tonchev.breakingbad.data.networking.services

import com.tsvetomir.tonchev.breakingbad.data.models.remote.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {
    companion object {
        private const val GET_ALL_CHARACTERS_PATH = "api/characters"
        private const val CATEGORY_QUERY = "category"
    }

    @GET(GET_ALL_CHARACTERS_PATH)
    fun getAllCharacters(@Query(CATEGORY_QUERY) category: String): Call<List<CharacterResponse>>
}