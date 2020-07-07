package com.jh.controleponto.servicesFuncionarioService

import com.jh.controleponto.documents.Funcionario
import com.jh.controleponto.enums.PerfilEnum
import com.jh.controleponto.repositories.FuncionarioRepository
import com.jh.controleponto.services.FuncionarioService
import com.jh.controleponto.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.lang.Exception

@ExtendWith(SpringExtension::class)
@SpringBootTest
class FuncionarioServiceTest {

    @Autowired
    val funcionarioService: FuncionarioService? = null

    @MockBean
    val funcionarioRepository: FuncionarioRepository? = null

    private val email: String = "email@email.com"
    private val cpf: String = "11111111111"
    private val id: String = "1"

    @BeforeEach
    @Throws(Exception::class)
    fun setup() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
//        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assertions.assertNotNull(funcionario)
    }

//    @Test
//    fun testBuscarFuncionarioPorId() {
//        val funcionario: Funcionario? = this.funcionarioService?.buscarPorId(id)
//        Assertions.assertNotNull(funcionario)
//    }
//
//    @Test
//    fun testBuscarFuncionarioPorEmail() {
//        val funcionario: Funcionario? = this.funcionarioService?.buscarPorEmail(email)
//        Assertions.assertNotNull(funcionario)
//    }
//
//    @Test
//    fun testBuscarFuncionarioPorCpf() {
//        val funcionario: Funcionario? = this.funcionarioService?.buscarPorCpf(cpf)
//        Assertions.assertNotNull(funcionario)
//    }

    private fun funcionario(): Funcionario =
            Funcionario("Nome", email, SenhaUtils().gerarBcrypt("123"), cpf, PerfilEnum.ROLE_USUARIO, id)
}