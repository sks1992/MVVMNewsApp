package com.sk.runnerapp.ui.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sk.runnerapp.repository.NewsRepository

class NewsViewModelProviderFactory(
    val app: Application, val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewMode(app, newsRepository) as T
    }
}