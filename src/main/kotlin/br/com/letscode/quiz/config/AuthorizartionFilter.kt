package br.com.letscode.quiz.config

import br.com.letscode.quiz.exception.AuthorizarionException
import br.com.letscode.quiz.service.UsuarioService
import br.com.letscode.quiz.utils.JwtTokenUtil
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthorizartionFilter(
    val service: UsuarioService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) = run {

        if(request.requestURI == "/authentication") filterChain.doFilter(request, response)

        val requestTokenHeader: String? = request.getHeader("Authorization");
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            val jwtToken = requestTokenHeader.substring(7)
            val userlogin = JwtTokenUtil.getUserLoginFromToken(jwtToken)
            val usuario = service.getUsuarioByLogin(userlogin)
            JwtTokenUtil.validateToken(jwtToken, usuario)
            filterChain.doFilter(request, response)
        } else {
            throw AuthorizarionException("Usuario nao autorizado")
        }
    }

}
