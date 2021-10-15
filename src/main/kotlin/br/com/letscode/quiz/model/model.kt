package br.com.letscode.quiz.model

import javax.persistence.*

@Entity
@Table
data class Filme(
    @Id @GeneratedValue val id: Int,
    val nome: String,
    val ano: Int,
    val nota: Float
)

@Entity
@Table
data class Usuario(
    @Id @GeneratedValue val id: Int = 0,
    val nome: String,
    val senha: String,
    val login: String,
    val qntVida: Int = 0,
    val pontos: Int = 0
)

