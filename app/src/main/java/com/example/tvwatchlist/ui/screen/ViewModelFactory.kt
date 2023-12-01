package com.example.tvwatchlist.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tvwatchlist.data.SeriesRepository
import com.example.tvwatchlist.ui.screen.detail.DetailViewModel
import com.example.tvwatchlist.ui.screen.list.SeriesViewModel

class ViewModelFactory(private val repository: SeriesRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(SeriesViewModel::class.java) ->
                SeriesViewModel(repository) as T

            modelClass.isAssignableFrom(DetailViewModel::class.java) ->
                DetailViewModel(repository) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}