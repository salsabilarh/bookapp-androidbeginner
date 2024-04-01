package com.dicoding.submissionandroidpemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBooks: RecyclerView
    private val list = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        list.addAll(getListBooks())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun getListBooks(): ArrayList<Book> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataAuthor = resources.getStringArray(R.array.data_author)
        val dataPublisher = resources.getStringArray(R.array.data_publisher)
        val dataPublicationYear = resources.getStringArray(R.array.data_publicationYear)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val listBook = ArrayList<Book>()
        for (i in dataName.indices) {
            val book = Book(
                dataName[i],
                dataPhoto.getResourceId(i, -1),
                dataAuthor[i],
                dataPublisher[i],
                dataPublicationYear[i],
                dataDescription[i]
            )
            listBook.add(book)
        }
        dataPhoto.recycle()
        return listBook
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                startActivity(Intent(this, AboutActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBooks.adapter = listBookAdapter

        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailIntent.putExtra("key_book", data)
                startActivity(detailIntent)
            }
        })
    }

    private fun showSelectedBook(book: Book) {
        Toast.makeText(this, "Kamu memilih " + book.name, Toast.LENGTH_SHORT).show()
    }
}
