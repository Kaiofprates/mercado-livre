package com.orange.produtos

import io.micronaut.core.annotation.Introspected
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
@Entity
@Table(name = "caracteristica")
data class Caracteristica(
    @field:NotBlank val marca: String,
    @field:NotBlank val modelo: String,
    @field:NotNull  val unidades: Long
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var produto: Long? = null

}
