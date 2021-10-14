package br.com.letscode.quiz.controller

import br.com.letscode.quiz.service.FilmeService

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("filme")
class FilmeController(
    val service: FilmeService
)