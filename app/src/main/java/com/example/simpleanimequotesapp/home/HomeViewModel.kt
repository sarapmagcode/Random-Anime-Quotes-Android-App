package com.example.simpleanimequotesapp.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleanimequotesapp.network.RandomQuote
import com.example.simpleanimequotesapp.network.RandomQuoteApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _randomQuote = MutableLiveData<RandomQuote>()
    val randomQuote: LiveData<RandomQuote> = _randomQuote

    init {
        getRandomQuote()
    }

    private fun getRandomQuote() {
        viewModelScope.launch {
            try {
                _randomQuote.value = RandomQuoteApi.retrofitService.getRandomQuote()
            } catch (e: Exception) {
                Log.d("HomeFragment", "Error: $e")
            }
        }
    }

    fun refresh() {
        getRandomQuote()
    }
}