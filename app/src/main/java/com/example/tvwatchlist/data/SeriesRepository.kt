package com.example.tvwatchlist.data

import com.example.tvwatchlist.model.Series
import com.example.tvwatchlist.model.SeriesData

class SeriesRepository {

    fun getSeries(): List<Series> {
        return SeriesData.series
    }

    fun searchSeries(query: String): List<Series> {
        val data = SeriesData.series.filter {
            it.name.contains(query, ignoreCase = true)
        }
        return data.ifEmpty {
            SeriesData.series
        }
    }

    fun searchSeriesById(id: String): Series {
        return SeriesData.series.first{
            it.id == id
        }
    }
}