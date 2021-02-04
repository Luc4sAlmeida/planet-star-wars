package com.almeida.planetstarwars.advice

import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun jsonParseException(
        request: HttpServletRequest,
        response: HttpServletResponse,
        exception: Exception
    ) : ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage(ERROR_JSON_PARSE, exception.message ?: "Invalid JSON"), HttpStatus.BAD_REQUEST)
    }
}
