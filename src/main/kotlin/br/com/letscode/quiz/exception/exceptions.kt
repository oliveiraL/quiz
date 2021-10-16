package br.com.letscode.quiz.exception


class LoginException(message: String): RuntimeException(message)

class AuthorizarionException(message: String): RuntimeException(message)

class AuthenticationException(message: String): RuntimeException(message)