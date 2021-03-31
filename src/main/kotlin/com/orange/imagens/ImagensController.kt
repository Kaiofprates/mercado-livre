package com.orange.imagens

import com.orange.produtos.ProdutoRepository
import com.orange.usuario.UsuarioRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.*
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.multipart.CompletedFileUpload
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory

@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api")
class ImagensController(
    private val usuarioRepository: UsuarioRepository,
    private val produtoRepository: ProdutoRepository
) {
    /**
     *  adicionando primeiramente uma imagem por vez.
     *  futuramente adicionar multiplas
     */

    private val log = LoggerFactory.getLogger(ImagensController::class.java)


    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Post("/produtos/{id}/imagens")
    fun adicionaImagens(
        id: Long,
        file: CompletedFileUpload,
        authentication: Authentication
    ): HttpResponse<Any>{

        // por hora faremos toda essa lógica no controller mesmo [ REFATORAR ]

        var produto = produtoRepository.findById(id)
        if(produto.isEmpty) return notFound()

        var username = authentication.attributes["username"]
        var usuario = usuarioRepository.findByEmail(username.toString())
        if(usuario.isEmpty) return HttpResponse.unprocessableEntity()

        if(produto.get().usuario.email != usuario.get().email) return unprocessableEntity()

        var url = "http://localhost:8080/api/produtos/${id}/imagens/${file.filename}"

        // adiciona nova imagem a lista

        produto.get().adicionaImagem(url)

        log.info(produto.toString())

        // por hora enviando a string interia até conseguir achar um jeito de usar o uribuilder

        return ok(url)
    }


}