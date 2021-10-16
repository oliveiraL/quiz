package br.com.letscode.quiz.service

import br.com.letscode.quiz.exception.LoginException
import br.com.letscode.quiz.model.Usuario
import br.com.letscode.quiz.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val repository: UsuarioRepository
) {
    fun create(usuario: Usuario): Usuario = run {
        validarLogin(usuario.login)
        repository.save(usuario).also {
            println("Usuário criado com sucesso")
        }
    }

    fun validarLogin(login: String){
        repository.findByLogin(login).also {
            if (it !== null) throw LoginException("Login já cadastrado")
        }
    }

    fun getAll(): List<Usuario> = repository.findAll()


}