package br.com.letscode.quiz.repository

import br.com.letscode.quiz.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Int> {
    fun findByLogin(login: String): Usuario?
}