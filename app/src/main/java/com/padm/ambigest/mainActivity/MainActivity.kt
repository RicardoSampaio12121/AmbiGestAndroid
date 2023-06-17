package com.padm.ambigest.mainActivity

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.padm.ambigest.R
import com.padm.ambigest.consultas.consultasFragment
import com.padm.ambigest.preferences.PreferencesFragment

class MainActivity : AppCompatActivity() {

    private val MAIN_HOME_FRAG_TAG = "mainHomeFragTag"
    private val MAIN_CONSULTAS_FRAG_TAG= "mainConsultasFragTag"
    private val MAIN_PREFERENCES_FRAG_TAG= "mainPreferencesFragTag"

    private lateinit var homeButton: TextView
    private lateinit var consultasButton: TextView
    private lateinit var preferencesButton: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        homeButton = findViewById(R.id.main_tv_home)
        consultasButton = findViewById(R.id.main_tv_consultas)
        preferencesButton = findViewById(R.id.main_tv_preferences)

        supportFragmentManager.beginTransaction()
            .add(
                R.id.main_fl_page,
                HomeFragment.newInstance(),
                MAIN_HOME_FRAG_TAG)
            .commit()

        consultasButton.setOnClickListener{


            if(supportFragmentManager.findFragmentByTag(MAIN_CONSULTAS_FRAG_TAG) != null)
                return@setOnClickListener

            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.main_fl_page,
                    consultasFragment.newInstance(),
                    MAIN_CONSULTAS_FRAG_TAG)
                .commit()
            changeMenuButtonsAppearance(1)
        }

        homeButton.setOnClickListener{
            if(supportFragmentManager.findFragmentByTag(MAIN_HOME_FRAG_TAG) != null)
                return@setOnClickListener

            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.main_fl_page,
                    HomeFragment.newInstance(),
                    MAIN_HOME_FRAG_TAG
                )
                .commit()

            changeMenuButtonsAppearance(0)
        }

        preferencesButton.setOnClickListener{
            if(supportFragmentManager.findFragmentByTag(MAIN_PREFERENCES_FRAG_TAG) != null)
                return@setOnClickListener

            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.main_fl_page,
                    PreferencesFragment.newInstance(),
                    MAIN_PREFERENCES_FRAG_TAG
                )
                .commit()

            changeMenuButtonsAppearance(2)
        }
    }

    private fun changeMenuButtonsAppearance(active: Int) {
        val inactiveColor = ContextCompat.getColor(this, R.color.menuInactive)
        val activeColor = ContextCompat.getColor(this, R.color.menuActive)

        homeButton.setTextColor(if (active == 0) activeColor else inactiveColor)
        homeButton.setHintTextColor(if (active == 0) activeColor else inactiveColor)
        homeButton.compoundDrawables[0]?.setTint(if (active == 0) activeColor else inactiveColor)

        consultasButton.setTextColor(if (active == 1) activeColor else inactiveColor)
        consultasButton.setHintTextColor(if (active == 1) activeColor else inactiveColor)
        consultasButton.compoundDrawables[0]?.setTint(if (active == 1) activeColor else inactiveColor)

        preferencesButton.setTextColor(if (active == 2) activeColor else inactiveColor)
        preferencesButton.setHintTextColor(if (active == 2) activeColor else inactiveColor)
        preferencesButton.compoundDrawables[0]?.setTint(if (active == 2) activeColor else inactiveColor)
    }
}