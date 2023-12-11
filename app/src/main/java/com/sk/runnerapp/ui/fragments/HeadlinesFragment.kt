package com.sk.runnerapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.sk.runnerapp.R
import com.sk.runnerapp.adapters.NewsAdapter
import com.sk.runnerapp.ui.viewModel.NewsViewMode


class HeadlinesFragment : Fragment(R.layout.fragment_headlines) {
    lateinit var newsViewModel: NewsViewMode
    lateinit var newsAdapter: NewsAdapter
    lateinit var retryButton: Button
    lateinit var errorTextView: TextView
    lateinit var itemHeadlinesError: CardView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}