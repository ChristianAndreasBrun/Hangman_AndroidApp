package com.campusnet.hangman_app

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    lateinit var newWord:String
    lateinit var gameWord:TextView
    lateinit var letterSelected:EditText
    lateinit var hangmanImage:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameWord = findViewById(R.id.word)
        letterSelected = findViewById(R.id.letter)
        hangmanImage = findViewById(R.id.hangman)

        Hangman.GetRandomWord()
        PrintWord()
        Hangman.setMainActivity(this)

        //Efecto de gradiente para texto
        val paint = gameWord.paint
        val width = paint.measureText(gameWord.text.toString())
        gameWord.paint.shader = LinearGradient(
            0f, 0f, width, gameWord.textSize, intArrayOf(
                Color.parseColor("#bc046f"),
                Color.parseColor("#2ba9dd"),
            ), null, Shader.TileMode.REPEAT
        )
    }

    //Mensaje popUp
    fun showToast(message: String) {
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content),
            message, Snackbar.LENGTH_SHORT
        )
        val snackbarView = snackbar.view
        val params = snackbarView.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        snackbarView.layoutParams = params
        snackbar.show()

        Handler().postDelayed({
            snackbar.dismiss()
        }, 2000)
    }

    public fun PrintWord() {
        newWord = Hangman.GetWordInGame()
        gameWord.text = newWord
        letterSelected.text = null
        hangmanImage.setImageResource(Words.imageError[Hangman.errorCount])
        Hangman.Win(gameWord.text as String)
        //System.out.println(newWord)
    }

    public fun CheckLetter(view: View) {
        //Hangman.AddLetter(letterSelected.text.toString())
        //PrintWord()

        val selectedLetter = letterSelected.text.toString()
        if (isUsed(selectedLetter)) {
            showToast("Ya se ha usado la letra: $selectedLetter")
        }
        else
        {
            Hangman.AddLetter(selectedLetter)
            PrintWord()
        }
    }

    fun showWinScreen() {
        val intent = Intent(this, WinActivity::class.java)
        startActivity(intent)
    }

    fun showLooseScreen() {
        val intent = Intent(this, LoseActivity::class.java)
        startActivity(intent)
    }

    private fun isUsed(letter: String): Boolean {
        //return letter.length == 1 && letter[0].isLetter()
        return Hangman.isUsed(letter)
    }

}