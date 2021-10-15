package br.com.letscode.quiz.dto

data class UsuarioDTO(
    val nome: String = "",
    val login: String = ""
)

data class UsuarioCreateDTO(
    val nome: String,
    val senha: String,
    val login: String
)