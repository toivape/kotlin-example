package com.example.basicservice.service

import com.example.basicservice.db.Book
import com.example.basicservice.db.BookRepo
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus

private val logger = KotlinLogging.logger {}

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class BookNotFoundException(message: String) : RuntimeException(message)

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class BookExistsException(message: String) : RuntimeException(message)

@Service
class BookService(private val bookRepo: BookRepo) {

    fun listBooksByTitle() = bookRepo.listBooksByTitle()

    fun getBook(bookId: Long) =
            bookRepo.findByIdOrNull(bookId) ?: throw BookNotFoundException("Book not found by id $bookId")

    fun deleteBook(bookId: Long) {
        val book = getBook(bookId)
        logger.info { "Deleting book with id $bookId" }
        bookRepo.delete(book)
    }

    fun addBook(title: String, author: String, year: Int): Book {
        if (isExistingBook(title, author)) {
            throw BookExistsException("Book already exists: $title - $author")
        }

        val book = Book(id = 0, title = title, author = author, year = year)
        logger.info { "Adding new book $book" }
        return bookRepo.save(book)
    }

    fun updateBook(bookId: Long, title: String, author: String, year: Int): Book {
        val book = getBook(bookId)
        book.title = title
        book.author = author
        book.year = year
        logger.info { "Updating book $book" }
        return bookRepo.save(book)
    }

    private fun isExistingBook(title: String, author: String) = bookRepo.countByTitleAndAuthor(title, author) != 0L
}