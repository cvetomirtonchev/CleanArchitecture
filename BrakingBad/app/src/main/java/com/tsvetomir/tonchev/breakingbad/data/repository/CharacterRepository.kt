package com.tsvetomir.tonchev.breakingbad.data.repository

import com.tsvetomir.tonchev.breakingbad.data.models.remote.CharacterResponse
import com.tsvetomir.tonchev.breakingbad.data.networking.client.ApiResponse
import okhttp3.ResponseBody

interface CharacterRepository {

    suspend fun getAllCharacters(category: String): ApiResponse<List<CharacterResponse>>
}