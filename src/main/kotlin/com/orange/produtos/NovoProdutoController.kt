package com.orange.produtos

import com.orange.categoria.CategoriaRepository
import com.orange.usuario.UsuarioRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.badRequest
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api")
class NovoProdutoController(
    private val produtoRepository: ProdutoRepository,
    private val categoriaRepository: CategoriaRepository,
    private val usuarioRepository: UsuarioRepository
) {

    private val log = LoggerFactory.getLogger(NovoProdutoController::class.java)

    @Post("/produtos")
    fun novoProduto(@Body @Valid request: ProdutoRequest, authentication: Authentication): HttpResponse<Any>{
        var username = authentication.attributes["username"]
        var usuario = usuarioRepository.findByEmail(username.toString())
        if(usuario.isEmpty) return badRequest("Falha ao recuperar informações de login")

        val produto = produtoRepository.save(request.toModel(categoriaRepository, usuario.get()))
        log.info(produto.toString())
        return ok(request)
    }

}