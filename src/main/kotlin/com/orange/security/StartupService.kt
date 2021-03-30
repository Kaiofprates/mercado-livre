package com.orange.security

import com.orange.usuario.Usuario
import com.orange.usuario.UsuarioRepository
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import javax.inject.Singleton

@Singleton
class StartupService(private val usuarioRepository: UsuarioRepository) {

    private val log = LoggerFactory.getLogger(StartupService::class.java)
    private val cripto = BcriptService()

    @EventListener
    fun onStart(event: StartupEvent){
        val password = cripto.encode("senha12345")
        val usuario = usuarioRepository.save(Usuario(
            "teste@hotmail.com",
            password.toString(),
            LocalDateTime.now()
        ))

        log.info(usuario.toString())
    }



}