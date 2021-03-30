package com.orange.usuario

import io.micronaut.core.annotation.Introspected
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Introspected
@Entity
data class Usuario(

    val email: String,
    val password: String,
    val createdAt: LocalDateTime
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}