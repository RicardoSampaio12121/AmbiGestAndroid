package com.padm.ambigest.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.toSpannable
import com.padm.ambigest.R
import com.padm.ambigest.recoverPassword.RecoverPasswordActivity
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        val LOGIN_FRAG_FRAG_TAG = "loginFragFragTag"

        // Initialization
        supportFragmentManager.beginTransaction()
            .add(R.id.login_fl_view,
                LoginFragment.newInstance(),
                LOGIN_FRAG_FRAG_TAG)
            .addToBackStack(LOGIN_FRAG_FRAG_TAG)
            .commit()


        // Setting some styling settings

        val tvTitle = findViewById<TextView>(R.id.login_tv_title)
        tvTitle.text= Html.fromHtml("<font color=${Color.BLACK}>Bem-vindo a um mundo muito melhor com a </font>" +
                "<font color=${Color.GREEN}> ambiGest!!</font>")

        val backButton = findViewById<AppCompatImageButton>(R.id.login_ib_back_button)
        backButton.setOnClickListener{

            //TODO: If it's the first fragment of the activity, just finish it
            supportFragmentManager.popBackStack()
        }
    }
}