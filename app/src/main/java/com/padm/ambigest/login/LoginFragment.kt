package com.padm.ambigest.login

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import com.padm.ambigest.R
import com.padm.ambigest.databinding.FragmentLoginBinding
import com.padm.ambigest.mainActivity.MainActivity
import com.padm.ambigest.recoverPassword.RecoverPasswordActivity
import com.padm.ambigest.services.firebase.FirebaseAuthentication
import com.padm.ambigest.services.firebase.databaseModels.LoginUserModel
import com.padm.ambigest.services.firebase.databaseModels.NewUserModel


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
                    //TODO: This will eventually have to be injected instead of created here
                    val service = FirebaseAuthentication(requireActivity())

                    service.registerUser(NewUserModel(loginEtEmail.text.toString(),
                        loginEtPassword.text.toString())) { checker ->
                        if(checker){
                            //TODO: Do something here, or delete this entire if else block
                        }
                        else{
                            //TODO: Do something here, dunno what makes sense tbh
                        }
                    }
                }

                loginClLogin.setOnClickListener{
                    //TODO: This will eventually have to be injected instead of created here
                    val service = FirebaseAuthentication(requireActivity())

                    service.loginUser(LoginUserModel(loginEtEmail.text.toString(),
                        loginEtPassword.text.toString())){ checker ->

                        if(checker){
                            val intent = Intent(requireActivity(), MainActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            //TODO: Do something here
                        }
                    }
                }

                loginTvForgotPassword.setOnClickListener{
                    val service = FirebaseAuthentication(requireActivity())

                    if(loginEtEmail.text.isNullOrEmpty()){
                        loginEtEmail.requestFocus()
                        Toast.makeText(requireContext(), "Email address field must be filled.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                    service.recoverPassword(loginEtEmail.text.toString()){
                        if (it){
                            Toast.makeText(context, "Reset password email sent.", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(requireContext(), "Please, check if your email address is correct.", Toast.LENGTH_SHORT).show()
                        }
                    }
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