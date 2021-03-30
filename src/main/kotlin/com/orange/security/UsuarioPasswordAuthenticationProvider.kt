package com.orange.security

import com.orange.usuario.UsuarioRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton

@Singleton
class UsuarioPasswordAuthenticationProvider(
    private val usuarioRepository: UsuarioRepository,
    private val cripto: BcriptService
): AuthenticationProvider {

    private val log = LoggerFactory.getLogger(UsuarioPasswordAuthenticationProvider::class.java)

    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        val usuario =  usuarioRepository.findByEmail(authenticationRequest?.identity as String)
        log.info(usuario.toString())
        if(usuario.isPresent){
            if(cripto.matches(authenticationRequest.secret.toString(),usuario.get().password))
                return Flowable.just(UserDetails(usuario.get().email, listOf()))
            return Flowable.just(AuthenticationFailed())
        }else{
            return Flowable.just(AuthenticationFailed())
        }
    }
}