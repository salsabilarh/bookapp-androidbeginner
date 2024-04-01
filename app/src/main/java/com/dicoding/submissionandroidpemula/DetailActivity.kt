package com.dicoding.submissionandroidpemula

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataBook: Book? = intent.getParcelableExtra("key_book")
        dataBook?.let {
            val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
            val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
            val tvDetailAuthor: TextView = findViewById(R.id.tv_detail_author)
            val tvDetailPublisher: TextView = findViewById(R.id.tv_detail_publisher)
            val tvDetailPublicationYear: TextView = findViewById(R.id.tv_detail_publicationYear)
            val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)

            ivDetailPhoto.setImageResource(dataBook.photo)
            tvDetailName.text = dataBook.name
            tvDetailAuthor.text = dataBook.author
            tvDetailPublisher.text = dataBook.publisher
            tvDetailPublicationYear.text = dataBook.publicationYear
            tvDetailDescription.text = dataBook.description
        }
    }
}
