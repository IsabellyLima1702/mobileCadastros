package br.senai.sp.jandira.cadastroclinica.model

data class ResponsavelData(
    val nomeCompleto: String = "",
    val dataDeNascimento: String = "",
    val cpf: String = "",
    val telefone: String = "",
    val email: String = "",
    val cep: String = "",
    val adicionarSegundoResponsavel: Boolean = false
)

data class BebeData(
    val nomeCompleto: String = "",
    val dataDeNascimento: String = "",
    val sexo: String = "",
    val nacionalidade: String = "",
    val naturalidade: String = "",
    val peso: String = "",
    val alturaAoNascer: String = "",
    val tipoSanguineo: String = "",
    val certidaoDeNascimento: String = "",
    val cpf: String = ""
)

data class MedicoData(
    val nomeCompleto: String = "",
    val email: String = "",
    val cpf: String = "",
    val telefone: String = "",
    val crm: String = "",
    val sexo: String = "",
    val fotoUrl: String = ""
)

data class ClinicaData(
    val nome: String = "",
    val email: String = "",
    val cnpj: String = "",
    val telefone: String = "",
    val bairro: String = "",
    val rua: String = "",
    val numero: String = "",
    val cidade: String = "",
    val fotoUrl: String = ""
)
