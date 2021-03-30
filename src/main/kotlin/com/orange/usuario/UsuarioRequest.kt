package com.orange.usuario

import com.orange.security.BcriptService
import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class UsuarioRequest(
    @field:Email val email: String,
    @field:NotBlank @field:Size(min = 6) val password: String
){
    val createdAt: LocalDateTime = LocalDateTime.now()

    fun toModel(cripto: BcriptService): Usuario {
        return Usuario(email,
        cripto.encode(password),createdAt)
    }

}
