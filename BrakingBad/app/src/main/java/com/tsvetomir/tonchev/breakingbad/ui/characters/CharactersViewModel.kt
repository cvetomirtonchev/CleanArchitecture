package com.tsvetomir.tonchev.breakingbad.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsvetomir.tonchev.breakingbad.data.models.local.CharacterView
import com.tsvetomir.tonchev.breakingbad.data.models.remote.CharacterResponse
import com.tsvetomir.tonchev.breakingbad.domain.GetCharactersUseCase
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    private val mCharacterListLiveData = MutableLiveData<List<CharacterView>>()
    fun observeCharacterListLiveData() = mCharacterListLiveData as LiveData<List<CharacterView>>


    fun getAllCharacters(category: String) {
        viewModelScope.launch {
            GetCharactersUseCase.executeAsync(mapOf(GetCharactersUseCase.CATEGORY_PARAM to category))
                .onLeft {
                    // send error
                }.onRight { responseData ->
                    mCharacterListLiveData.value = responseData.map {
                        mapToViewModel(it)
                    }
                }
        }
    }

    private fun mapToViewModel(data: CharacterResponse): CharacterView {
        return CharacterView(
            id = data.id,
            img = data.img,
            name = data.name,
            nickname = data.nickname,
            status = data.status,
            appearance = data.appearance.toString(),
            occupation = data.occupation.toString()
        )
    }
}