package com.kevicsalazar.globant.devtest.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class NewsDetailDTO(
    @SerialName("documento")
    val document: NewsDocumentItem
) {

    @Serializable
    class NewsDocumentItem(
        @SerialName("id")
        val id: String,
        @SerialName("url")
        val url: String,
        @SerialName("source")
        val source: String,
        @SerialName("produto")
        val product: String,
        @SerialName("editoria")
        val editorial: String,
        @SerialName("subeditoria")
        val subeditorial: String,
        @SerialName("titulo")
        val title: String,
        @SerialName("credito")
        val credit: String,
        @SerialName("datapub")
        val date: String,
        @SerialName("horapub")
        val time: String,
        @SerialName("linhafina")
        val line: String,
        @SerialName("imagem")
        val imageUrl: String,
        @SerialName("thumbnail")
        val thumbnail: String,
        @SerialName("creditoImagem")
        val creditImage: String,
        @SerialName("legendaImagem")
        val legendImage: String,
        @SerialName("origem")
        val origin: String,
        @SerialName("corpoformatado")
        val body: String
    )

}