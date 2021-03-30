package com.orange.categoria

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api")
class CategoriaController(private val categoriaRepository: CategoriaRepository) {

    @Post("/categorias")
    fun novaCategoria(@Body @Valid request: CategoriaRequest): HttpResponse<Any> {

        if(categoriaRepository.existsByNome(request.nome)) return HttpResponse.badRequest(" Categoria já existente")

        var categoria = categoriaRepository.save(request.toModel(categoriaRepository))
        return HttpResponse.ok(categoria)
    }
}