package com.arsenic.diarycompose.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.arsenic.diarycompose.R


@Composable
fun QuoteSingleItem(quote: Quote, onClick: (quote: Quote?)->Unit) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier.padding(5.dp)
            .clickable {
                onClick(quote)
            }
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
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

            Spacer(modifier = Modifier.padding(5.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.quote?: "Default Text",
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
                    text = quote.author?: "Default Text",
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

        }
    }
}


