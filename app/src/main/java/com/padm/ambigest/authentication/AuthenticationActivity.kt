package com.padm.ambigest.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.padm.ambigest.R
import com.padm.ambigest.login.LoginActivity

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val tvUseEmail = findViewById<TextView>(R.id.authentication_tv_useEmail)
        val clLoginFacebook = findViewById<ConstraintLayout>(R.id.login_cl_fbButton)

        tvUseEmail.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        clLoginFacebook.setOnClickListener{

        }



    }
}