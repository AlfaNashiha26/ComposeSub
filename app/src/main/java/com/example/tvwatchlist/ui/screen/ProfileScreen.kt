package com.example.tvwatchlist.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tvwatchlist.R
import com.example.tvwatchlist.ui.theme.TVWatchlistTheme

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.deep_orange_light))
    ) {
        item {
            TopBar(modifier, onBackClick)
        }
        item {
            ProfileContent(modifier)
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    TVWatchlistTheme {
        ProfileScreen(onBackClick = { /*TODO*/ })
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
            text = stringResource(R.string.about_developer),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
                .padding(top = 20.dp, bottom = 20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.alfa),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(R.string.developer_name),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = stringResource(R.string.developer_origin),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxHeight()
                .background(Color.White)
        ) {
            BioItem(
                title = R.string.birthdate,
                description = R.string.dev_birthdate,
                modifier = modifier.padding(top = 10.dp)
            )
            BioItem(
                title = R.string.institution,
                description = R.string.dev_institution
            )
            BioItem(
                title = R.string.major,
                description = R.string.dev_major
            )
            BioItem(
                title = R.string.email,
                description = R.string.dev_email,
            )
            BioItem(
                title = R.string.Linkedin,
                description = R.string.dev_linkedin,
            )
            BioItem(
                title = R.string.github,
                description = R.string.dev_github,
            )
            BioItem(
                title = R.string.instagram,
                description = R.string.dev_instagram,
            )
        }
    }
}

@Composable
fun BioItem(
    title: Int,
    description: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(title),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = colorResource(R.color.deep_orange_dark),
        )
        Text(
            text = stringResource(description),
            color = Color.Black
        )
        Divider(
            color = colorResource(R.color.deep_orange_dark),
            thickness = 2.dp
        )
    }
}