package com.orange.categoria

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class CategoriaRequest(
    @field:NotBlank val nome: String,
    var categoriaId: Long? = null
){

    fun toModel(categoriaRepository: CategoriaRepository): Categoria{
        if(categoriaId != null){
            var categoria = categoriaRepository.findById(categoriaId!!)
            if(categoria.isPresent) {return Categoria(nome, categoria.get())
            }else{
                throw EmptyCategoryException("Não foi possível recuperar a categoria mãe indicada")
            }
        }
        return Categoria(nome)
    }

}
