package br.com.letscode.quiz.repository

import br.com.letscode.quiz.model.Filme
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmeRepository: JpaRepository<Filme, Int>

