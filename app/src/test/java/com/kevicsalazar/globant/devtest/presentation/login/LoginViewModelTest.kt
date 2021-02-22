package com.kevicsalazar.globant.devtest.presentation.login

import androidx.lifecycle.Observer
import com.kevicsalazar.globant.devtest.BaseViewModelTest
import com.kevicsalazar.globant.devtest.domain.usecases.LoginUseCase
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class LoginViewModelTest : BaseViewModelTest() {

    @MockK
    lateinit var loginUseCase: LoginUseCase

    private lateinit var viewModel: LoginViewModel

    override fun initialize() {
        viewModel = LoginViewModel(loginUseCase)
    }

    @Test
    fun `given user and password, when login called, then update live data for success state`() =
        runBlockingTest {

            // Given
            val mockedObserver = createViewStateObserver()
            viewModel.viewState.observeForever(mockedObserver)

            coEvery { loginUseCase.login(any(), any()) } just runs

            // When
            viewModel.login("devmobile", "uC&+}H4wg?rYbF:")

            // Then
            val slot = slot<LoginViewState>()
            verify { mockedObserver.onChanged(capture(slot)) }

            slot.captured shouldBeInstanceOf LoginViewState.Success::class.java

            coVerify { loginUseCase.login(any(), any()) }
        }

    private fun createViewStateObserver(): Observer<LoginViewState> =
        spyk(Observer { })

}
