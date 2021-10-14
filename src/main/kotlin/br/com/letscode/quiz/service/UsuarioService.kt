package br.com.letscode.quiz.service

import br.com.letscode.quiz.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val repository: UsuarioRepository
) {
}