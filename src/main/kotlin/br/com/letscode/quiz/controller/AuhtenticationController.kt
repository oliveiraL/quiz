package br.com.letscode.quiz.controller

import br.com.letscode.quiz.service.UsuarioService
import br.com.letscode.quiz.model.Usuario
import br.com.letscode.quiz.dto.UsuarioAutenticacaoDTO
import br.com.letscode.quiz.utils.JwtTokenUtil

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource

data class JWT(
        val token: String
)


@RestController
@RequestMapping("authentication")
class AuhtenticationController(
        val service: UsuarioService,
        val authenticationManager: AuthenticationManager
) {

    @PostMapping
    fun login(@RequestBody usuario: UsuarioAutenticacaoDTO): ResponseEntity<JWT> = run {
        val jwt = service.validarLogin(
                Usuario(
                login = usuario.login,
                senha = usuario.senha,
                nome = "")
        ).let {
            JwtTokenUtil.generateToken(it)
        }
        ResponseEntity.ok(JWT(jwt))
    }
}