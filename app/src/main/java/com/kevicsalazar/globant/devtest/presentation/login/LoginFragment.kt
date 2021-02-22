package com.kevicsalazar.globant.devtest.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kevicsalazar.globant.devtest.R
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel by viewModel<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewModel()
        setupEvents()
    }

    private fun setupView() {
        etUser.setText("devmobile")
        etPassword.setText("uC&+}H4wg?rYbF:")
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)
        viewModel.checkSession()
    }

    private fun setupEvents() {
        btnLogin.setOnClickListener {
            viewModel.login(etUser.text.toString(), etPassword.text.toString())
        }
    }

    private val viewStateObserver = Observer<LoginViewState> { state ->
        when (state) {
            is LoginViewState.Success -> goToHome()
            is LoginViewState.Error -> showError()
        }
    }

    private fun goToHome() {
        findNavController().navigate(R.id.action_loginFragment_to_newsListFragment)
    }

    private fun showError() {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

}