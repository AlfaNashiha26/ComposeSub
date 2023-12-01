package com.example.tvwatchlist.ui.screen.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tvwatchlist.data.SeriesRepository
import com.example.tvwatchlist.model.Series
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SeriesViewModel(private val repository: SeriesRepository) : ViewModel() {
    private val _groupedSeries = MutableStateFlow(
        repository.getSeries()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedSeries: StateFlow<Map<Char, List<Series>>> get() = _groupedSeries

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedSeries.value = repository.searchSeries(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}