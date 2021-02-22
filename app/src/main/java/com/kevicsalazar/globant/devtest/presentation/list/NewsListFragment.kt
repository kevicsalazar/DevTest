package com.kevicsalazar.globant.devtest.presentation.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kevicsalazar.globant.devtest.R
import com.kevicsalazar.globant.devtest.domain.entities.NewsItem
import kotlinx.android.synthetic.main.fragment_news_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewsListFragment : Fragment(R.layout.fragment_news_list) {

    private val viewModel by viewModel<NewsListViewModel>()
    private val newsAdapter by lazy { NewsListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupEvents()
        setupViewModel()
    }

    private fun setupView() {
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = newsAdapter
    }

    private fun setupEvents() {
        newsAdapter.setOnClickListener {
            goToDetail(it)
        }
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_logout -> viewModel.logout()
            }
            true
        }
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)
        viewModel.getNewsList()
    }


    private val viewStateObserver = Observer<NewsListViewState> { state ->
        when (state) {
            is NewsListViewState.Success -> updateList(state.items)
            is NewsListViewState.Error -> showError()
            is NewsListViewState.GoToLogin -> goToLogin()
        }
    }

    private fun updateList(items: List<NewsItem>) {
        newsAdapter.updateList(items)
    }

    private fun showError() {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

    private fun goToDetail(id: String) {
        val bundle = bundleOf("ID" to id)
        findNavController().navigate(R.id.action_newsListFragment_to_newsDetailFragment, bundle)
    }

    private fun goToLogin() {
        findNavController().navigate(R.id.action_newsListFragment_to_loginFragment)
    }

}