package com.orange.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton

@Singleton
class BcriptService: PasswordEncoder {

    private val bCryptPasswordEncoder = BCryptPasswordEncoder()

    override fun encode(rawPassword: CharSequence?): String {
        return bCryptPasswordEncoder.encode(rawPassword)
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
    return bCryptPasswordEncoder.matches(rawPassword, encodedPassword)
    }
}