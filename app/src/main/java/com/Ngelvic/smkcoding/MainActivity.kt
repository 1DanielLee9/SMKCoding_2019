package com.Ngelvic.smkcoding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        front_button_film.onClick {
//            val intent = Intent(this@MainActivity,ListMovieActivity::class.java)
//            startActivity(intent)

            startActivity(intentFor<ListMovieActivity>())
        }

        front_button_profile.onClick {
            startActivity(intentFor<ProfileActivity>())
        }

        favorit_movie.onClick {
            startActivity(intentFor<ListFavoriteActivity>())
        }

    }
}
