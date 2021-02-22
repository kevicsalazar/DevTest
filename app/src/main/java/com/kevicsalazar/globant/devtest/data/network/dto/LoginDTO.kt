package com.kevicsalazar.globant.devtest.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LoginDTO(
    @SerialName("token")
    val token: String
)