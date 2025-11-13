package br.senai.sp.jandira.cadastroclinica.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.cadastroclinica.components.*
import br.senai.sp.jandira.cadastroclinica.model.MedicoData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicoRegistrationScreen(
    onNavigateBack: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    var medicoData by remember { mutableStateOf(MedicoData()) }
    
    val sexoOptions = listOf("Masculino", "Feminino", "Outro")
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header
        RegistrationHeader(
            title = "Cadastro do Médico",
            subtitle = "Médico",
            icon = Icons.Default.Person
        )
        
        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            
            CustomTextField(
                value = medicoData.nomeCompleto,
                onValueChange = { medicoData = medicoData.copy(nomeCompleto = it) },
                label = "Nome completo",
                placeholder = "Digite o nome completo",
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = medicoData.email,
                onValueChange = { medicoData = medicoData.copy(email = it) },
                label = "E-mail",
                placeholder = "exemplo@email.com",
                leadingIcon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = medicoData.cpf,
                onValueChange = { medicoData = medicoData.copy(cpf = it) },
                label = "CPF",
                placeholder = "000.000.000-00",
                keyboardType = KeyboardType.Number,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = medicoData.telefone,
                onValueChange = { medicoData = medicoData.copy(telefone = it) },
                label = "TELEFONE",
                placeholder = "(00) 00000-0000",
                leadingIcon = Icons.Default.Phone,
                keyboardType = KeyboardType.Phone,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = medicoData.crm,
                onValueChange = { medicoData = medicoData.copy(crm = it) },
                label = "CRM",
                placeholder = "000.000.000-00",
                keyboardType = KeyboardType.Number,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomDropdown(
                value = medicoData.sexo,
                onValueChange = { medicoData = medicoData.copy(sexo = it) },
                label = "SEXO",
                options = sexoOptions,
                modifier = Modifier.fillMaxWidth()
            )
            
            FileUploadSection(
                title = "Upload de foto",
                onFileSelected = { /* Handle file selection */ }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Bottom buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomButton(
                    text = "← Voltar para o início",
                    onClick = onNavigateBack,
                    isSecondary = true,
                    modifier = Modifier.weight(1f)
                )
                
                CustomButton(
                    text = "SALVAR",
                    onClick = onSave,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedicoScreenPreview() {
    MedicoRegistrationScreen()
}