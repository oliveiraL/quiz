package br.com.letscode.quiz.utils

import br.com.letscode.quiz.dto.UsuarioDTO
import br.com.letscode.quiz.model.Usuario
fun <T> T.alsoCustom(novoParame: Int, code: (T) -> Unit): T {
    println("")
    code(this)
    return this
}

fun  <T> T.algo(t: T): Unit = print("")

fun Usuario.convertToDTO(): UsuarioDTO = UsuarioDTO(
    nome = this.nome,
    login = this.login
)