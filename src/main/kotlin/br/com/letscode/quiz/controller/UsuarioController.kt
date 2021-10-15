package br.com.letscode.quiz.controller

import br.com.letscode.quiz.dto.UsuarioCreateDTO
import br.com.letscode.quiz.dto.UsuarioDTO
import br.com.letscode.quiz.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("usuario")
class UsuarioController(val service: UsuarioService){

    @PostMapping
    fun create(@RequestBody usuario: UsuarioCreateDTO): ResponseEntity<UsuarioDTO> = run {



//        val usuarioCopia: UsuarioDTO = usuarioDTO.copy(login = usuario.login)

        val usuarioDTO = usuario.apply {
            println("teste")
        }.let {
            UsuarioDTO(nome = it.nome)
        }



        ResponseEntity.ok(usuarioDTO)
    }
}


