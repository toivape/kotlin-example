package com.example.basicservice.controller

import com.example.basicservice.service.BookService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Basic CRUD operations for book.
 */
@RestController
@RequestMapping("/api/v1/books")
class BookController(private val bookService: BookService) {

    @GetMapping("/{bookId}")
    fun getBook(@PathVariable("bookId") bookId: Long) = bookService.getBook(bookId)

    @GetMapping
    fun listBooks() = bookService.listBooksByTitle()

    @DeleteMapping("/{bookId}")
    fun deleteBook(@PathVariable("bookId") bookId: Long) {
        bookService.deleteBook(bookId)
    }

    @PostMapping
    fun addBook(@Valid @RequestBody bookForm: BookForm) =
            bookService.addBook(bookForm.title!!, bookForm.author!!, bookForm.year!!)

    @PutMapping
    fun updateBook(@Valid @RequestBody bookForm: BookForm) =
            bookService.updateBook(bookForm.id!!, bookForm.title!!, bookForm.author!!, bookForm.year!!)
}