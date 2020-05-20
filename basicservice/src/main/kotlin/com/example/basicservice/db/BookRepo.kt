package com.example.basicservice.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BookRepo : JpaRepository<Book, Long> {

    @Query("select a from Book a order by title asc")
    fun listBooksByTitle(): List<Book>

    fun countByTitleAndAuthor(title: String, author: String): Long
}