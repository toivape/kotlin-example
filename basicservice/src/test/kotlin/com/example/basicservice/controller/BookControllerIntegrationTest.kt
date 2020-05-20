package com.example.basicservice.controller

import com.example.basicservice.db.Book
import com.example.basicservice.db.BookRepo
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

fun Book.toJSON(): String = jacksonObjectMapper().writeValueAsString(this)

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookControllerIntegrationTest {

    @Autowired
    private lateinit var wac: WebApplicationContext

    @Autowired
    private lateinit var bookRepo: BookRepo

    private var mockMvc: MockMvc? = null

    @BeforeAll
    fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()
    }

    @BeforeEach
    fun before() {
        bookRepo.deleteAll()
    }

    @Test
    fun `List all books in alphabetical order by title`() {
        addBooksToDb()
        mockMvc!!.perform(get("/api/v1/books").accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(jsonPath("$", hasSize<Any>(3)))
                .andExpect(jsonPath("$[0].title").value("Journey to the Center of the Earth"))
                .andExpect(jsonPath("$[2].title").value("The Time Machine"))
    }

    @Test
    fun `Find a book`() {
        val book = addBooksToDb().first()
        mockMvc!!.perform(get("/api/v1/books/{bookId}", book.id).accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.title").value(book.title))
    }

    @Test
    fun `When book is not found HTTP NOT_FOUND is returned`() {
        mockMvc!!.perform(get("/api/v1/books/{bookId}", "9999999999").accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().`is`(HttpStatus.NOT_FOUND.value()))
                .andExpect(MockMvcResultMatchers.content().string("Book not found by id 9999999999"))
    }

    @Test
    fun `Delete a book`() {
        val bookIdToDelete = addBooksToDb().first().id
        mockMvc!!.perform(delete("/api/v1/books/{bookId}", bookIdToDelete).accept(APPLICATION_JSON))
                .andExpect(status().isOk)

        assertTrue(bookRepo.findById(bookIdToDelete).isEmpty)
    }

    @Test
    fun `Add a book`() {
        val newBook = getWellsMoreauBook()
        mockMvc!!.perform(post("/api/v1/books").contentType(APPLICATION_JSON).content(newBook.toJSON()))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.title").value("The Island of Doctor Moreau"))
    }

    @Test
    fun `Add a duplicate book returns error`() {
        val book = addBooksToDb().first()
        mockMvc!!.perform(post("/api/v1/books").contentType(APPLICATION_JSON).content(book.toJSON()))
                .andDo(print())
                .andExpect(status().`is`(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.content().string("Book already exists: ${book.title} - ${book.author}"))
    }

    @Test
    fun `Update a book`() {
        val timeMachineBook = addBooksToDb().first { it.title == "The Time Machine" }
        assertEquals("The Time Machine", timeMachineBook.title)

        val updateBook = getWellsMoreauBook(timeMachineBook.id)

        mockMvc!!
                .perform(put("/api/v1/books").contentType(APPLICATION_JSON).content(updateBook.toJSON()))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.title").value("The Island of Doctor Moreau"))

        val savedBook = bookRepo.getOne(timeMachineBook.id)
        assertEquals(updateBook.author, savedBook.author)
        assertEquals(updateBook.title, savedBook.title)
        assertEquals(updateBook.year, savedBook.year)
    }

    @Test
    fun `Test book form validation message`() {
        val emptyBook = Book(id = 0, title = " ", author = " ", year = 0)
        mockMvc!!.perform(post("/api/v1/books").contentType(APPLICATION_JSON).content(emptyBook.toJSON()))
                .andDo(print())
                .andExpect(status().`is`(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$", hasSize<Any>(2)))
                .andExpect(jsonPath("$.[?(@.field == \"title\" && @.error == \"Book title is required.\")]").exists())
                .andExpect(jsonPath("$.[?(@.field == \"author\" && @.error == \"Book author is required.\")]").exists())
    }

    /**
     * Books here are not in alphabetical order.
     */
    private fun addBooksToDb(): List<Book> {
        return bookRepo.saveAll(listOf(
                Book(0, "Moby Dick", "Herman Melville", 1851),
                Book(0, "Journey to the Center of the Earth", "Jules Verne", 1864),
                Book(0, "The Time Machine", "H. G. Wells", 1895)
        ))
    }

    private fun getWellsMoreauBook(id: Long = 0) = Book(id = id, title = "The Island of Doctor Moreau", author = "H.G.Wells", year = 1896)
}