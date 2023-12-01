package com.example.tvwatchlist.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tvwatchlist.R
import com.example.tvwatchlist.data.SeriesRepository
import com.example.tvwatchlist.model.Series
import com.example.tvwatchlist.ui.screen.ViewModelFactory
import com.example.tvwatchlist.ui.theme.TVWatchlistTheme

@Composable
fun DetailScreen(
    seriesId: String,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(SeriesRepository())
    ),
    navigateBack: () -> Unit
) {
    val series = viewModel.getSeriesById(seriesId)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.deep_orange_light))
    ) {
        item {
            TopBar(modifier, navigateBack)
        }
        item {
            DetailContent(series = series)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    TVWatchlistTheme {
        DetailScreen(
            seriesId = "1",
            navigateBack = {}
        )
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(colorResource(R.color.deep_orange_dark))
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .clickable { onBackClick() }
        )
        Text(
            text = stringResource(R.string.series_detail),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    series: Series
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.White)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
            .padding(10.dp)
        ) {
            Image(
                painter = painterResource(series.image),
                contentDescription = null,
                modifier = modifier
                    .width(120.dp)
                    .height(180.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = series.name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                )
                ItemDetails(
                    stringRes = R.string.genre,
                    item = series.genre
                )
                ItemDetails(
                    stringRes = R.string.year,
                    item = series.year
                )
                ItemDetails(
                    stringRes = R.string.rating,
                    item = series.rating
                )
            }
        }
        Divider(color = colorResource(R.color.deep_orange_dark), thickness = 4.dp)
        Text(
            text = stringResource(R.string.synopsis),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colors.primary,
            modifier = modifier
                .padding(start = 10.dp, top = 10.dp)
        )
        Text(
            text = series.description,
            fontSize = 17.sp,
            color = colorResource(R.color.cream_dark),
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(10.dp)
        )
    }
}

@Composable
fun ItemDetails(stringRes: Int, item: String) {
    Text(
        text = stringResource(stringRes, item),
        color = MaterialTheme.colors.primary,
        fontSize = 20.sp,
    )
}