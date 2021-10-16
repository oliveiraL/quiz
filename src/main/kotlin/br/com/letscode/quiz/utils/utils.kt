package br.com.letscode.quiz.utils

import br.com.letscode.quiz.dto.UsuarioDTO
import br.com.letscode.quiz.exception.AuthorizarionException
import br.com.letscode.quiz.model.Usuario
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*

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

object JwtTokenUtil {

    private const val JWT_TOKEN_VALIDITY = 60L

    private val secret: String = "letscode"

    //retorna o username do token jwt
    fun getUserLoginFromToken(token: String): String =
        getClaimFromToken(token, Claims::getSubject)

    //retorna expiration date do token jwt
    fun getExpirationDateFromToken(token: String): Date
        = getClaimFromToken(token, Claims::getExpiration)


    fun <T> getClaimFromToken(token: String, claimsResolver: (clam: Claims) -> T): T = run {
        val claims: Claims = getAllClaimsFromToken(token)
        claimsResolver(claims)
    }

    //para retornar qualquer informação do token nos iremos precisar da secret key
    private fun getAllClaimsFromToken(token: String): Claims =
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body

    private fun isTokenExpired(token: String): Boolean = run {
        val expiration = getExpirationDateFromToken(token)
        expiration.before(Date())
    }

    //gera token para user
    fun generateToken(usuario: Usuario): String = doGenerateToken(usuario.login)

    private fun doGenerateToken(subject: String, claims: Map<String, Any> = mapOf()): String =
        Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
            .signWith(SignatureAlgorithm.HS256, secret).compact()

    //valida o token
    fun validateToken(token: String, usuario: Usuario?) =
        getUserLoginFromToken(token).let { name ->
            if(usuario?.login !== name || isTokenExpired(token))
                throw AuthorizarionException("Token invalido")
        }
}