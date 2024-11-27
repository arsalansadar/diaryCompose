package com.arsenic.diarycompose.notes

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.arsenic.diarycompose.R


@Composable
fun QuotesDetails(quote: Quote) {
    BackHandler {
        DataManager.switchPage(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(15.dp)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.LightGray,
                        Color.Black
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier.padding(5.dp)
        ) {

            Column(modifier = Modifier
                .padding(15.dp)) {

                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = "Dummy image",
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(40.dp)
                        .rotate(180F)
                        .background(color = Color.Black)
                )
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE))
                        .fillMaxWidth(.4f)
                        .height(1.dp)
                )

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }


        }
    }
}