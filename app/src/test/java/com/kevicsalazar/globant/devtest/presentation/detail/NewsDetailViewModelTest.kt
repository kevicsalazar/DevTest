package com.kevicsalazar.globant.devtest.presentation.detail

import androidx.lifecycle.Observer
import com.kevicsalazar.globant.devtest.BaseViewModelTest
import com.kevicsalazar.globant.devtest.domain.usecases.GetNewsDetailUseCase
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class NewsDetailViewModelTest : BaseViewModelTest() {

    @MockK
    lateinit var getNewsDetailUseCase: GetNewsDetailUseCase

    private lateinit var viewModel: NewsDetailViewModel

    override fun initialize() {
        viewModel = NewsDetailViewModel(getNewsDetailUseCase)
    }

    @Test
    fun `when get news detail called, then update live data for success state`() =
        runBlockingTest {

            // Given
            val mockedObserver = createViewStateObserver()
            viewModel.viewState.observeForever(mockedObserver)

            coEvery { getNewsDetailUseCase.getNewsDetail(any()) } returns mockk {
                every { title } returns "Titulo"
            }

            // When
            viewModel.getNewsDetail("1")

            // Then
            val slot = slot<NewsDetailViewState>()
            verify { mockedObserver.onChanged(capture(slot)) }

            slot.captured shouldBeInstanceOf NewsDetailViewState.Success::class.java
            val detail = (slot.captured as NewsDetailViewState.Success).item
            detail.title shouldBeEqualTo "Titulo"

            coVerify { getNewsDetailUseCase.getNewsDetail(any()) }
        }

    private fun createViewStateObserver(): Observer<NewsDetailViewState> =
        spyk(Observer { })

}
