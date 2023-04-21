package com.padm.ambigest.login

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.core.text.toSpannable
import com.padm.ambigest.R
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Setting some styling settings

        val tvTitle = findViewById<TextView>(R.id.login_tv_title)
        tvTitle.text= Html.fromHtml("<font color=${Color.BLACK}>Bem-vindo a um mundo muito melhor com a </font>" +
                "<font color=${Color.GREEN}> ambiGest!!</font>")

        val tvForgotPassword = findViewById<TextView>(R.id.login_tv_forgotPassword)
        val spannableString = SpannableString(tvForgotPassword.text.toSpannable())
        spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, 0)
        tvForgotPassword.text = spannableString;

    }
}