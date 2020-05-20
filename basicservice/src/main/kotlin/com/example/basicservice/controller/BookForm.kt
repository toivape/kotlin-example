package com.example.basicservice.controller

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class BookForm(

        val id: Long?,

        @field:Size(min = 1, max = 100, message = "{bookForm.title.length}")
        @field:NotBlank(message = "{bookForm.title.required}")
        val title: String?,

        @field:Size(min = 1, max = 100, message = "{bookForm.author.length}")
        @field:NotBlank(message = "{bookForm.author.required}")
        val author: String?,

        @field:NotNull(message = "{bookForm.year.required}")
        val year: Int?
)
