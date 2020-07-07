package com.jh.controleponto.services.impl

import com.jh.controleponto.documents.Empresa
import com.jh.controleponto.repositories.EmpresaRepository
import com.jh.controleponto.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscaPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}