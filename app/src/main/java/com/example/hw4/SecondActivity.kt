package com.example.hw4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.hw4.R

class SecondActivity : AppCompatActivity() {

    private lateinit var tvText: TextView
    private lateinit var ivGallery: ImageView

    private val fuGallery = registerForActivityResult(ActivityResultContracts.GetContent()) {
        ivGallery.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        ivGallery = this.findViewById(R.id.iv_gallery)
        tvText = this.findViewById(R.id.tv_text)

        acceptText()
        chooseImageFromGallery()
    }

    private fun acceptText() {
        val text = intent.getStringExtra(MainActivity.TEXT_KEY)
        if (text != null) {
            tvText.text = text
        }
    }

    private fun chooseImageFromGallery() {
        ivGallery.setOnClickListener {
            fuGallery.launch("image/*")
        }
    }
}