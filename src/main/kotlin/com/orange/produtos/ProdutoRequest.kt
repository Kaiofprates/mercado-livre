package com.orange.produtos

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.*

@Introspected
data class ProdutoRequest(
    @field:NotBlank val nome: String,
    @field:NotNull @field:Positive val valor: BigDecimal,
    @field:NotNull @field:Min(0) val quantidade: Long,
    @field:NotBlank @field:Size(max = 1000) val descricao: String,
    @field:NotNull val categoria: Long,
    @field:Size(min = 3) val caracteristica: List<Caracteristica>
)
