package com.orange.usuario

import io.micronaut.core.annotation.Introspected
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.time.LocalDateTime
import javax.persistence.*

@Introspected
@Entity
@Table(name = "usuario")
data class Usuario(

    val email: String,
    val password: String,
    val createdAt: LocalDateTime
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}