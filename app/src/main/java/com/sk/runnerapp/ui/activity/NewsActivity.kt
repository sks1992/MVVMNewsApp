package com.sk.runnerapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sk.runnerapp.R
import com.sk.runnerapp.databinding.ActivityNewsBinding
import com.sk.runnerapp.db.ArticleDatabase
import com.sk.runnerapp.repository.NewsRepository
import com.sk.runnerapp.ui.viewModel.NewsViewMode
import com.sk.runnerapp.ui.viewModel.NewsViewModelProviderFactory

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewMode: NewsViewMode
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, repository)
        newsViewMode =
            ViewModelProvider(this, viewModelProviderFactory)[NewsViewMode::class.java]

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}