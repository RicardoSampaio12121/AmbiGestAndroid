package com.padm.ambigest.recoverPassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.padm.ambigest.R

class RecoverPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        val RECOVER_PASSWORD_EMAIL_FRAG_TAG = "recoverPassEmailFT"
        val RECOVER_PASSWORD_CODE_FRAG_TAG = "recoverPassCodeFT"
        val RECOVER_PASSWORD_PASS_FRAG_TAG = "recoverPassPassFT"

        var currentlyVisibleFragment = RECOVER_PASSWORD_EMAIL_FRAG_TAG

        supportFragmentManager.beginTransaction()
            .add(R.id.recoverPassword_fl_steps,
                RecoverPasswordEmailInputFragment.newInstance(),
                RECOVER_PASSWORD_EMAIL_FRAG_TAG)
            .addToBackStack(RECOVER_PASSWORD_EMAIL_FRAG_TAG)
            .commit()

        val nextButton = findViewById<ConstraintLayout>(R.id.recoverPassword_cl_next)

        nextButton.setOnClickListener {

            when (currentlyVisibleFragment) {
                RECOVER_PASSWORD_EMAIL_FRAG_TAG -> {

                    currentlyVisibleFragment = RECOVER_PASSWORD_CODE_FRAG_TAG
                    supportFragmentManager.beginTransaction()
                        .add(
                            R.id.recoverPassword_fl_steps,
                            RecoverPasswordCodeInputFragment.newInstance(),
                            RECOVER_PASSWORD_CODE_FRAG_TAG)
                        .addToBackStack(RECOVER_PASSWORD_CODE_FRAG_TAG)
                        .commit()
                }
                RECOVER_PASSWORD_CODE_FRAG_TAG -> {

                    currentlyVisibleFragment = RECOVER_PASSWORD_PASS_FRAG_TAG
                    supportFragmentManager.beginTransaction()
                        .add(
                            R.id.recoverPassword_fl_steps,
                            RecoverPasswordPassInputFragment.newInstance(),
                            RECOVER_PASSWORD_PASS_FRAG_TAG)
                        .addToBackStack(RECOVER_PASSWORD_PASS_FRAG_TAG)
                        .commit()
                }
                RECOVER_PASSWORD_PASS_FRAG_TAG -> {
                    //Do some login here
                }
            }
        }

        val backButton = findViewById<AppCompatImageButton>(R.id.recoverPassword_ib_back_button)

        backButton.setOnClickListener{

            if(currentlyVisibleFragment == RECOVER_PASSWORD_EMAIL_FRAG_TAG){
                finish()
                return@setOnClickListener
            }

            currentlyVisibleFragment = supportFragmentManager
                .getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 2)
                .name!!

            supportFragmentManager.popBackStack()
        }
    }
}