package com.android.myappnative.data
import kotlinx.serialization.Serializable
@Serializable
data class Arbol (
    val arbolId: Int,
    val name: String,
    val cientificName: String,
    val detail: String? = null,
    val icon: Int) {
}

