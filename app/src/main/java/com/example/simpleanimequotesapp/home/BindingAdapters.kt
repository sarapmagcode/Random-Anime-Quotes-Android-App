package com.example.simpleanimequotesapp.home

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.simpleanimequotesapp.R
import com.example.simpleanimequotesapp.network.RandomQuote
import com.google.android.material.button.MaterialButton

@BindingAdapter("quoteText")
fun bindQuote(textView: TextView, randomQuote: RandomQuote?) {
    textView.text = textView.context.getString(R.string.quote, randomQuote?.quote)
}

@BindingAdapter("animeText")
fun bindAnime(textView: TextView, randomQuote: RandomQuote?) {
    textView.text = textView.context.getString(R.string.anime, randomQuote?.anime)
}

@BindingAdapter("characterText")
fun bindCharacter(textView: TextView, randomQuote: RandomQuote?) {
    textView.text = textView.context.getString(R.string.character, randomQuote?.character)
}

@BindingAdapter("refreshClick")
fun bindRefreshClick(refreshButton: MaterialButton, viewModel: HomeViewModel) {
    refreshButton.setOnClickListener { viewModel.refresh() }
}