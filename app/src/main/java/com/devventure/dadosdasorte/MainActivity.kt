package com.devventure.dadosdasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado01 = findViewById<ImageView>(R.id.Dado01)
        val dado02 = findViewById<ImageView>(R.id.Dado02)

        val btn = findViewById<Button>(R.id.btnJogar)
        val shareBttn = findViewById<FloatingActionButton>(R.id.shareBttn)

        val text = findViewById<TextView>(R.id.WelcomeMessage)
        val playerName = intent.getStringExtra("player_name")

        text.text = getString(R.string.WelcomeMessage,playerName)

        val imagensDadoSeisLados = listOf(R.drawable.dice_1,R.drawable.dice_2,
                                        R.drawable.dice_3,R.drawable.dice_4,
                                        R.drawable.dice_5,R.drawable.dice_6)

        btn.setOnClickListener {
            dado01.setImageResource(imagensDadoSeisLados.random())
            dado02.setImageResource(imagensDadoSeisLados.random())
        }


        shareBttn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Que sorte!")
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")

            if(intent.resolveActivity(this.packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Você não tem o WhatsApp instalado", Toast.LENGTH_LONG).show()
            }
        }


        Log.i("CICLO DE VIDA", "ON CREATE")
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO DE VIDA","ON START")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO DE VIDA", "ON RESUME")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLO DE VIDA", "ON PAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO DE VIDA", "ON STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO DE VIDA", "ON DESTROY")
    }
}