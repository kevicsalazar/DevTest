package com.kevicsalazar.globant.devtest.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kevicsalazar.globant.devtest.R
import com.kevicsalazar.globant.devtest.domain.entities.NewsDetailItem
import kotlinx.android.synthetic.main.fragment_news_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    private val viewModel by viewModel<NewsDetailViewModel>()

    private val id by lazy { requireArguments().getString("ID").orEmpty() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setupViewModel()
    }

    private fun setupEvents() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)
        viewModel.getNewsDetail(id)
    }

    private val viewStateObserver = Observer<NewsDetailViewState> { state ->
        when (state) {
            is NewsDetailViewState.Success -> updateView(state.item)
            is NewsDetailViewState.Error -> showError()
        }
    }

    private fun updateView(item: NewsDetailItem) {
        tvTitle.text = item.title
    }

    private fun showError() {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

}