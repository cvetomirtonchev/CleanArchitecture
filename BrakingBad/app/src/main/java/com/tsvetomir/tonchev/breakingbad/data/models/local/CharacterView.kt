package com.tsvetomir.tonchev.breakingbad.data.models.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterView(
    val id: Long,
    val name: String,
    val occupation: String,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: String
) : Parcelable
