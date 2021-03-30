package com.orange.usuario

import com.orange.security.BcriptService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.badRequest
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/api")
class UsuarioController(private val usuarioRepository: UsuarioRepository) {

    private val log = LoggerFactory.getLogger(UsuarioController::class.java)
    private val cripto = BcriptService()

    @Post("/usuarios")
    fun novoUsuario(@Body @Valid request: UsuarioRequest): HttpResponse<Any>{
        val validateUser = usuarioRepository.findByEmail(request.email)
        if(validateUser.isPresent) return badRequest("Não foi possível realizar o cadastro com o email informado")
        val usuario = usuarioRepository.save(request.toModel(cripto))
        log.info(usuario.toString())
        return ok()
    }

}