package com.padm.ambigest.recoverPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padm.ambigest.R


class RecoverPasswordPassInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recover_password_pass_input, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RecoverPasswordPassInputFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}