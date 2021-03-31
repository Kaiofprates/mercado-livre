package com.orange.produtos

import com.orange.categoria.CategoriaRepository
import com.orange.usuario.Usuario
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.*

@Introspected
data class ProdutoRequest(
    @field:NotBlank val nome: String,
    @field:NotNull @field:Positive val valor: BigDecimal,
    @field:NotNull @field:Min(0) val quantidade: Long,
    @field:NotBlank @field:Size(max = 1000) val descricao: String,
    @field:NotNull val categoria: Long,
    @field:Size(min = 3) val caracteristica: ArrayList<Caracteristica>
) {
    fun toModel(categoriaRepository: CategoriaRepository, usuario: Usuario): Produto {
        val categoria = categoriaRepository.findById(categoria)
        if(categoria.isPresent){
            return Produto(nome, valor, quantidade, descricao, categoria.get(), caracteristica, usuario, LocalDateTime.now())
        }else{
            throw CategoriaNotFound("Não foi possível recuperar a categoria informada")
        }
    }

}

class CategoriaNotFound(s: String) : Exception() {
    override val message: String? = s
}
