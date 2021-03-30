package com.orange.categoria

import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import javax.persistence.*

@Entity
data class Categoria(
    @Column(unique = true)
    val nome: String,
    @OneToOne
    var categoria: Categoria? = null
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}