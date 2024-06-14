package com.campusnet.hangman_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)
    }

    fun backMenu(view: View) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}