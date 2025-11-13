package br.senai.sp.jandira.cadastroclinica.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.cadastroclinica.components.*
import br.senai.sp.jandira.cadastroclinica.model.BebeData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BebeRegistrationScreen(
    onNavigateBack: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    var bebeData by remember { mutableStateOf(BebeData()) }
    
    val sexoOptions = listOf("Masculino", "Feminino")
    val tipoSanguineoOptions = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header
        RegistrationHeader(
            title = "Cadastro do Bebê",
            subtitle = "Seu Bebê",
            icon = Icons.Default.Face
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
                value = bebeData.nomeCompleto,
                onValueChange = { bebeData = bebeData.copy(nomeCompleto = it) },
                label = "Nome completo",
                placeholder = "Digite o nome completo",
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = bebeData.dataDeNascimento,
                onValueChange = { bebeData = bebeData.copy(dataDeNascimento = it) },
                label = "Data de nascimento",
                placeholder = "Selecione a data",
                leadingIcon = Icons.Default.DateRange,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomDropdown(
                    value = bebeData.sexo,
                    onValueChange = { bebeData = bebeData.copy(sexo = it) },
                    label = "Sexo",
                    options = sexoOptions,
                    isRequired = true,
                    modifier = Modifier.weight(1f)
                )
                
                CustomDropdown(
                    value = bebeData.nacionalidade,
                    onValueChange = { bebeData = bebeData.copy(nacionalidade = it) },
                    label = "Nacionalidade",
                    options = listOf("Brasileiro"),
                    placeholder = "🇧🇷 Brasileiro",
                    isRequired = true,
                    modifier = Modifier.weight(1f)
                )
            }
            
            CustomTextField(
                value = bebeData.naturalidade,
                onValueChange = { bebeData = bebeData.copy(naturalidade = it) },
                label = "Naturalidade",
                placeholder = "Cidade/Estado",
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            // Health section
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF8FAFC)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color(0xFFEF4444),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Saúde ao Nascer",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        CustomTextField(
                            value = bebeData.peso,
                            onValueChange = { bebeData = bebeData.copy(peso = it) },
                            label = "Peso",
                            placeholder = "Ex: 3,2",
                            keyboardType = KeyboardType.Decimal,
                            isRequired = true,
                            modifier = Modifier.weight(1f)
                        )
                        
                        CustomTextField(
                            value = bebeData.alturaAoNascer,
                            onValueChange = { bebeData = bebeData.copy(alturaAoNascer = it) },
                            label = "Altura ao nascer (cm)",
                            placeholder = "Ex: 50",
                            keyboardType = KeyboardType.Number,
                            isRequired = true,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    
                    CustomDropdown(
                        value = bebeData.tipoSanguineo,
                        onValueChange = { bebeData = bebeData.copy(tipoSanguineo = it) },
                        label = "Tipo Sanguíneo",
                        options = tipoSanguineoOptions,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            
            // Documents section
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF8FAFC)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Assignment,
                            contentDescription = null,
                            tint = Color(0xFF6366F1),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Documentos",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                    
                    CustomTextField(
                        value = bebeData.certidaoDeNascimento,
                        onValueChange = { bebeData = bebeData.copy(certidaoDeNascimento = it) },
                        label = "Certidão de Nascimento",
                        placeholder = "Número da certidão",
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    CustomTextField(
                        value = bebeData.cpf,
                        onValueChange = { bebeData = bebeData.copy(cpf = it) },
                        label = "CPF",
                        placeholder = "000.000.000-00 (OPCIONAL)",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            
            FileUploadSection(
                title = "Upload de arquivos",
                onFileSelected = { /* Handle file selection */ }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Bottom button
            CustomButton(
                text = "SALVAR",
                onClick = onSave,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BebeRegistrationScreenPreview() {
    BebeRegistrationScreen()
}