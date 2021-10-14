package br.com.letscode.quiz.controller

import br.com.letscode.quiz.service.UsuarioService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("usuario")
class UsuarioController(
    val service: UsuarioService
)