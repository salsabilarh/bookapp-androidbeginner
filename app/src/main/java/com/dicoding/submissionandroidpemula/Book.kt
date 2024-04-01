package com.dicoding.submissionandroidpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val name: String,
    val photo: Int,
    val author: String,
    val publisher: String,
    val publicationYear: String,
    val description: String
) : Parcelable
