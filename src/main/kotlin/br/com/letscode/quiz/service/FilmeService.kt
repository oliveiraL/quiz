package br.com.letscode.quiz.service

import br.com.letscode.quiz.repository.FilmeRepository
import org.springframework.stereotype.Service

@Service
class FilmeService(val repository: FilmeRepository) {
}