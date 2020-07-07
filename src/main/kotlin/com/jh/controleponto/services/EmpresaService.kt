package com.jh.controleponto.services

import com.jh.controleponto.documents.Empresa

interface EmpresaService {

    fun buscaPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa

}