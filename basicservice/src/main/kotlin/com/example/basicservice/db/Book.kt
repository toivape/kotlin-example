package com.example.basicservice.db

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "book")
data class Book(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        val id: Long,

        @Column(name = "title", length = 100, nullable = false)
        @field:Size(min = 1, max = 100)
        @field:NotBlank(message = "title is mandatory")
        var title: String,

        @Column(name = "author", length = 100, nullable = false)
        @field:Size(min = 1, max = 100)
        @field:NotBlank(message = "author is mandatory")
        var author: String,

        @Column(name = "year", nullable = false)
        var year: Int
)