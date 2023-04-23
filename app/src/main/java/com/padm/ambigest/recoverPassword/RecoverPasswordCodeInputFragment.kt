package com.padm.ambigest.recoverPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padm.ambigest.R


class RecoverPasswordCodeInputFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recover_password_code_input, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RecoverPasswordCodeInputFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}