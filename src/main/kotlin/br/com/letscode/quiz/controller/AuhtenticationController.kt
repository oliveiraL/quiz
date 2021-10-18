package br.com.letscode.quiz.controller

import br.com.letscode.quiz.service.UsuarioService
import br.com.letscode.quiz.model.Usuario
import br.com.letscode.quiz.dto.UsuarioAutenticacaoDTO

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity

data class JWT(
        val token: String
)


@RestController
@RequestMapping("authentication")
class AuhtenticationController(
        val service: UsuarioService
) {

    @PostMapping
    fun login(@RequestBody usuario: UsuarioAutenticacaoDTO): ResponseEntity<JWT> = run {
        service.validarLogin(
                Usuario(
                login = usuario.login,
                senha = usuario.senha,
                nome = "")
        )
        ResponseEntity.ok(JWT(""))
    }
}