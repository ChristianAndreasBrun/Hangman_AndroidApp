package com.campusnet.hangman_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val startGame = findViewById<Button>(R.id.playGame)

        startGame.setOnClickListener { startGame() }
    }

    private fun startGame() {
        Hangman.errorCount = 0;
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}