package com.kevicsalazar.globant.devtest.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class NewsItemDTO(
    @SerialName("id_documento")
    val id: String,
    @SerialName("chapeu")
    val chapeu: String,
    @SerialName("titulo")
    val title: String,
    @SerialName("linha_fina")
    val line: String,
    @SerialName("data_hora_publicacao")
    val date: String,
    @SerialName("url")
    val url: String,
    @SerialName("imagem")
    val imageUrl: String,
    @SerialName("source")
    val source: String
)