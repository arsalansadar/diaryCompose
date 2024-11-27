package com.arsenic.diarycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arsenic.diarycompose.notes.DataManager
import com.arsenic.diarycompose.notes.QuoteListScreen
import com.arsenic.diarycompose.notes.QuotesDetails
import com.arsenic.diarycompose.ui.theme.DiaryComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            DiaryComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(1F),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    App()
                }


            }

        }
    }

    @Composable
    fun App() {
        if (DataManager.isDataLoaded.value) {

            if (DataManager.currentPage.value == Pages.LISTING) {
                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPage(it)
                }
            } else {
                DataManager.currentQueue?.let { QuotesDetails(quote = it) }
            }

        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(1f)
            ) {
                Text(
                    text = "Loading..."
                )

            }
        }
    }
}


enum class Pages {
    LISTING,
    DETAIL
}

