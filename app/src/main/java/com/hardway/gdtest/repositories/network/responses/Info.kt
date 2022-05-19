package com.hardway.gdtest.repositories.network.responses

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)