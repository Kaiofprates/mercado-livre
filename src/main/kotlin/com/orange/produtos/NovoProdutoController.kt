package com.orange.produtos

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.ok
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
class NovoProdutoController {

    @Post("/produtos")
    fun novoProduto(@Body @Valid request: ProdutoRequest): HttpResponse<Any>{
        return ok(request)
    }

}