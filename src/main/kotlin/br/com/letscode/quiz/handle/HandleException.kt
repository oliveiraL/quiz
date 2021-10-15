package br.com.letscode.quiz.handle

import br.com.letscode.quiz.exception.LoginException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

data class Error(
    val message: String?,
    val code: Int
)

@ControllerAdvice
class HandleException : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [LoginException::class])
    protected fun handleConflict(
        ex: RuntimeException, request: WebRequest
    ): ResponseEntity<Error> = ResponseEntity.status(422).body(
        Error(
            ex.message,
            422
        )
    )
}