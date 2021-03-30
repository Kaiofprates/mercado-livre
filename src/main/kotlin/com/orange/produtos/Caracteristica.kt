package com.orange.produtos

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class Caracteristica(
    @field:NotBlank val marca: String,
    @field:NotBlank val modelo: String,
    @field:NotNull  val unidades: Long
)
