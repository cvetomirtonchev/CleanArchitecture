package com.tsvetomir.tonchev.breakingbad.domain

import com.tsvetomir.tonchev.breakingbad.data.models.remote.CharacterResponse
import com.tsvetomir.tonchev.breakingbad.data.networking.client.ApiResponse
import com.tsvetomir.tonchev.breakingbad.data.repository.CharacterRepositoryImpl
import com.tsvetomir.tonchev.breakingbad.ui.base.BaseUseCase
import com.tsvetomir.tonchev.breakingbad.ui.base.Either

object GetCharactersUseCase : BaseUseCase<Either<String?, List<CharacterResponse>>>() {
    const val CATEGORY_PARAM = "category"

    override suspend fun run(withData: Map<String, Any>?): Either<String?, List<CharacterResponse>> {
        val category = withData?.get(CATEGORY_PARAM) as String
        val response = CharacterRepositoryImpl.getAllCharacters(category)
        val responseData = response.responseData
        return if (response.responseStatus == ApiResponse.STATUS_OK && responseData != null) {
            Either.Right(responseData)
        } else {
            Either.Left(response.error)
        }
    }
}