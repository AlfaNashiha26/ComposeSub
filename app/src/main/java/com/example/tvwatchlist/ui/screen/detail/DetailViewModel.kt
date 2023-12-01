package com.example.tvwatchlist.ui.screen.detail

import androidx.lifecycle.ViewModel
import com.example.tvwatchlist.data.SeriesRepository
import com.example.tvwatchlist.model.Series

class DetailViewModel(
    private val repository: SeriesRepository
) : ViewModel() {
    fun getSeriesById(id: String): Series {
        return repository.searchSeriesById(id)
    }
}