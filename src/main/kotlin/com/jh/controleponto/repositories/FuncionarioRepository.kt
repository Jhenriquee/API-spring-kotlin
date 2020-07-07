package com.jh.controleponto.repositories

import com.jh.controleponto.documents.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository

interface FuncionarioRepository : MongoRepository<Funcionario, String> {

    fun findByEmail(email: String): Funcionario?

    fun findByCpf(cpf: String): Funcionario?
}