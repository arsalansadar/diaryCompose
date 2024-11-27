package com.arsenic.diarycompose.notes

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.arsenic.diarycompose.Pages
import com.google.gson.Gson
import java.nio.charset.Charset
import java.util.Queue

object DataManager {
    var data = emptyArray<Quote>()
    var currentQueue: Quote? = null

    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true

    }

    fun switchPage(quote: Quote?){
        if (currentPage.value == Pages.LISTING){
            currentPage.value = Pages.DETAIL
            currentQueue = quote
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}