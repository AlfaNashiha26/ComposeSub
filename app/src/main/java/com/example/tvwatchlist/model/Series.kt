package com.example.tvwatchlist.model

data class Series(
    val id: String,
    val name: String,
    val year: String,
    val genre: String,
    val description: String,
    val image: Int,
    val rating: String,
    val link: String
)