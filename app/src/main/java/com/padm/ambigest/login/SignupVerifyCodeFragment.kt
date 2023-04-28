package com.padm.ambigest.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padm.ambigest.R
import com.padm.ambigest.databinding.FragmentSignupVerifyCodeBinding

class SignupVerifyCodeFragment : Fragment(R.layout.fragment_signup_verify_code) {

    private lateinit var binding: FragmentSignupVerifyCodeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupVerifyCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            confirmRegisterClButton.setOnClickListener{
                if(!verifyInputs()){
                    //TODO: Add a toast here
                    return@setOnClickListener
                }

                //TODO: Call method to confirm code
                val tmpResult = true


            }
        }
    }

    private fun verifyInputs(): Boolean{
        return true
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SignupVerifyCodeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}