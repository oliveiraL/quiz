package br.com.letscode.quiz.utils

fun <T> T.alsoCustom(novoParame: Int, code: (T) -> Unit, code2: (T) -> Unit ): T {
    code(this)
    return this
}
