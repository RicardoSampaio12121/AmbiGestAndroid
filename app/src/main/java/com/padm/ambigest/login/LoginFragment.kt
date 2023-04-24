package com.padm.ambigest.login

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import com.padm.ambigest.R
import com.padm.ambigest.databinding.FragmentLoginBinding
import com.padm.ambigest.recoverPassword.RecoverPasswordActivity


class LoginFragment : Fragment(R.layout.fragment_login) {

    val SIGNUP_VERIFY_CODE_FRAG_TAG = "signupVerifyCodeFragTag"
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.apply {
                val spannableString = SpannableString(loginTvForgotPassword.text.toSpannable())
                spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, 0)
                loginTvForgotPassword.text = spannableString;

                loginTvForgotPassword.setOnClickListener {
                    val intent = Intent(requireActivity(), RecoverPasswordActivity::class.java)
                    startActivity(intent)
                }

                loginClSignupButton.setOnClickListener{
                    requireActivity().supportFragmentManager.beginTransaction()
                        .add(R.id.login_fl_view,
                            SignupVerifyCodeFragment.newInstance(),
                            SIGNUP_VERIFY_CODE_FRAG_TAG)
                        .addToBackStack(SIGNUP_VERIFY_CODE_FRAG_TAG)
                        .commit()
                }
            }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}