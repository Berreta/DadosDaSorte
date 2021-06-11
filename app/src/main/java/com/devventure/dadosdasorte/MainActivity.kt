package com.devventure.dadosdasorte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado01 = findViewById<TextView>(R.id.Dado1)
        val dado02 = findViewById<TextView>(R.id.Dado2)
        val btn = findViewById<Button>(R.id.btnJogar)


        btn.setOnClickListener() {
            dado01.text =  randomNumber().toString()
            dado02.text = randomNumber().toString()
        }

    }

    private fun randomNumber() : Int {
        return (1..6).random()
    }
}