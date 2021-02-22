package com.kevicsalazar.globant.devtest.presentation.list

import androidx.lifecycle.Observer
import com.kevicsalazar.globant.devtest.BaseViewModelTest
import com.kevicsalazar.globant.devtest.domain.usecases.GetNewsListUseCase
import com.kevicsalazar.globant.devtest.domain.usecases.LogoutUseCase
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldHaveSize
import org.junit.Test

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class NewsListViewModelTest : BaseViewModelTest() {

    @MockK
    lateinit var getNewsListUseCase: GetNewsListUseCase
    @MockK
    lateinit var logoutUseCase: LogoutUseCase

    private lateinit var viewModel: NewsListViewModel

    override fun initialize() {
        viewModel = NewsListViewModel(getNewsListUseCase, logoutUseCase)
    }

    @Test
    fun `when get list called, then update live data for success state`() =
        runBlockingTest {

            // Given
            val mockedObserver = createViewStateObserver()
            viewModel.viewState.observeForever(mockedObserver)

            coEvery { getNewsListUseCase.getNewsList() } returns listOf(mockk(), mockk())

            // When
            viewModel.getNewsList()

            // Then
            val slot = slot<NewsListViewState>()
            verify { mockedObserver.onChanged(capture(slot)) }

            slot.captured shouldBeInstanceOf NewsListViewState.Success::class.java
            (slot.captured as NewsListViewState.Success).items shouldHaveSize 2

            coVerify { getNewsListUseCase.getNewsList() }
        }

    private fun createViewStateObserver(): Observer<NewsListViewState> =
        spyk(Observer { })

}
