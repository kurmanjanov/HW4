package com.example.hw4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var fabGo: FloatingActionButton
    private lateinit var etInput: EditText
    private lateinit var cardGoogle: MaterialCardView
    private lateinit var cardYoutube: MaterialCardView
    private lateinit var cardWhatsapp: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fabGo = this.findViewById(R.id.fab_go)
        etInput = this.findViewById(R.id.et_input)
        cardGoogle = this.findViewById(R.id.card_google)
        cardYoutube = this.findViewById(R.id.card_youtube)
        cardWhatsapp = this.findViewById(R.id.card_whatsapp)

        goToSecondActivity()

        goToLink(cardGoogle, "https://www.google.com/search?q=")
        goToLink(cardYoutube, "https://www.youtube.com/results?search_query=")
        goToLink(cardWhatsapp, "https://wa.me/")
    }

    private fun goToSecondActivity() {
        fabGo.setOnClickListener {
            val text = etInput.text.toString().trim()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(TEXT_KEY, text)
            startActivity(intent)
        }
    }

    private fun goToLink(card: MaterialCardView, usl: String) {
        card.setOnLongClickListener {
            val text = etInput.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("$usl$text")
            startActivity(intent)
            false
        }
    }

    companion object {
        const val TEXT_KEY = "TEXT"
    }
}