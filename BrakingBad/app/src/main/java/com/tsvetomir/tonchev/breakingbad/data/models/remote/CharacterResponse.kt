package com.tsvetomir.tonchev.breakingbad.data.models.remote

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("char_id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("occupation")
    val occupation: List<String>,
    @SerializedName("img")
    val img: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("appearance")
    val appearance: List<Int>,
    @SerializedName("portrayed")
    val portrayed: String,
    @SerializedName("category")
    val category: String
)
