package com.orange.produtos

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ProdutoRepository: JpaRepository<Produto, Long> {
}