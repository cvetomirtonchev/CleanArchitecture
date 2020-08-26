package com.tsvetomir.tonchev.breakingbad.ui.characters.characterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsvetomir.tonchev.breakingbad.data.models.local.CharDetailsView
import com.tsvetomir.tonchev.breakingbad.data.models.local.CharacterView

class CharacterDetailsViewModel : ViewModel() {

    private val mCharacterDetailsListLiveData = MutableLiveData<List<CharDetailsView>>()
    fun observeCharacterDetailsListLiveData() =
        mCharacterDetailsListLiveData as LiveData<List<CharDetailsView>>

    fun mapCharacterDetails(characterView: CharacterView) {
        val charDetails = mutableListOf<CharDetailsView>()
        charDetails.add(CharDetailsView("Name", characterView.name))
        charDetails.add(
            CharDetailsView(
                "Occupation",
                characterView.occupation.replace("[", "").replace("]", "")
            )
        )
        charDetails.add(CharDetailsView("Status", characterView.status))
        charDetails.add(CharDetailsView("Nickname", characterView.nickname))
        charDetails.add(
            CharDetailsView(
                "Season Appearance",
                characterView.appearance.replace("[", "").replace("]", "")
            )
        )
        mCharacterDetailsListLiveData.value = charDetails
    }
}