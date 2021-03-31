package com.orange.produtos

import com.orange.categoria.Categoria
import com.orange.usuario.Usuario
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
@Introspected
@Entity
@Table(name = "produto")
data class Produto(
    val nome: String,
    val valor: BigDecimal,
    val quantidade: Long,
    val descricao: String,
    @OneToOne
    val categoria: Categoria,
    @ManyToMany(mappedBy = "produto", cascade = arrayOf(CascadeType.PERSIST))
    val caracteristica: List<Caracteristica>,
    @ManyToOne
    val usuario: Usuario,
    val criadoEm: LocalDateTime

){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}