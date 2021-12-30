package com.nadia.frenzy.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nadia.frenzy.R
import com.nadia.frenzy.data.RegisterData
import com.nadia.frenzy.databinding.FragmentRegisterBinding
import com.nadia.frenzy.ui.main.MainViewModel
import com.nadia.frenzy.utils.Session
import com.nadia.frenzy.utils.Validation
import com.nadia.frenzy.utils.gone
import com.nadia.frenzy.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<RegisterViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        setupObservers()
        setupListeners()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.getRegisterLiveData().observe(viewLifecycleOwner, {
            binding.loadingBar.gone()
            if(it != null){
                Toast.makeText(requireContext(), "Register Success", Toast.LENGTH_SHORT).show()

                val email: String = binding.emailInputEdit.text.toString()
                val password: String = binding.passInputEdit.text.toString()

                Session.login(requireContext(), email, password, it)

                mainViewModel.updateNavigationButtonVisibility(View.VISIBLE)

                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            } else {
                Toast.makeText(requireContext(), "Invalid Register", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupListeners() {
        binding.loginTxt.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.registerButton.setOnClickListener {
            registerNewUser()
        }
    }

    private fun registerNewUser() {
        val name = binding.nameInputEdit.text.toString()
        if (Validation.isValidName(name).not()) {
            binding.nameInputLayout.error = getString(R.string.error_invalid_name)
            return
        }

        val username = binding.usernameInputEdit.text.toString()
        if (Validation.isValidUsername(username).not()) {
            binding.usernameInputLayout.error = getString(R.string.error_invalid_username)
            return
        }

        val email = binding.emailInputEdit.text.toString()
        if (Validation.isValidEmail(email).not()) {
            binding.emailInputLayout.error = getString(R.string.error_invalid_email)
            return
        }

        val password = binding.passInputEdit.text.toString()
        if (Validation.isValidPassword(password).not()) {
            binding.passInputLayout.error = getString(R.string.error_invalid_password)
            return
        }

        val registerData = RegisterData(name, email, username , password)
        viewModel.userRegister(registerData)
        binding.loadingBar.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}