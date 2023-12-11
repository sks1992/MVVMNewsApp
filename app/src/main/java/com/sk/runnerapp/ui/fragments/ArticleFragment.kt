package com.sk.runnerapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.sk.runnerapp.databinding.FragmentArticleBinding
import com.sk.runnerapp.ui.activity.NewsActivity
import com.sk.runnerapp.ui.viewModel.NewsViewMode

class ArticleFragment : Fragment(/*R.layout.fragment_article*/) {
    lateinit var newsViewMode: NewsViewMode
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewMode = (activity as NewsActivity).newsViewMode
        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener {
            newsViewMode.addToFavorites(article)
            Snackbar.make(view, "Add to favourites", Toast.LENGTH_SHORT).show()

        }
    }
}