package com.example.basicservice.controller

import com.example.basicservice.service.BookExistsException
import com.example.basicservice.service.BookNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BookNotFoundException::class)
    fun handleBadRequest(ex: BookNotFoundException, request: WebRequest) =
            handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.NOT_FOUND, request)


    @ExceptionHandler(BookExistsException::class)
    fun handleBadRequest(ex: BookExistsException, request: WebRequest) =
            handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.BAD_REQUEST, request)

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, errorsToJsonArray(ex), applicationJson(), HttpStatus.BAD_REQUEST, request)
    }

    fun applicationJson(): HttpHeaders {
        val headers = HttpHeaders()
        headers.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
        return headers
    }

    fun errorsToJsonArray(ex: MethodArgumentNotValidException): String {
        val fieldErrors = ex.bindingResult.fieldErrors.joinToString(",\n") { toError(it.field, it.defaultMessage ?: "") }
        return "[$fieldErrors]"
    }

    fun toError(fieldName: String, error: String) =
            """
            {"field":"$fieldName","error":"$error"}
            """.trimIndent()
}