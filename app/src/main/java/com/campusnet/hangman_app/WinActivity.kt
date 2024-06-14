package com.campusnet.hangman_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
    }

    fun backMenu(view: View) {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}