package br.senai.sp.jandira.cadastroclinica.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.cadastroclinica.R
import br.senai.sp.jandira.cadastroclinica.components.*
import br.senai.sp.jandira.cadastroclinica.model.ClinicaData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClinicaRegistrationScreen(
    onNavigateBack: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    var clinicaData by remember { mutableStateOf(ClinicaData()) }
    
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagem de fundo
        Image(
            painter = painterResource(id = R.drawable.plano),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Overlay branco com bordas arredondadas superiores
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White)
        )
        
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            RegistrationHeader(
                title = "Cadastro da Clínica",
                subtitle = "Clínica",
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
                value = clinicaData.nome,
                onValueChange = { clinicaData = clinicaData.copy(nome = it) },
                label = "Nome",
                placeholder = "Digite o nome completo",
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = clinicaData.email,
                onValueChange = { clinicaData = clinicaData.copy(email = it) },
                label = "E-mail",
                placeholder = "exemplo@email.com",
                leadingIcon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = clinicaData.cnpj,
                onValueChange = { clinicaData = clinicaData.copy(cnpj = it) },
                label = "CNPJ",
                placeholder = "000.000.000-00",
                keyboardType = KeyboardType.Number,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = clinicaData.telefone,
                onValueChange = { clinicaData = clinicaData.copy(telefone = it) },
                label = "TELEFONE",
                placeholder = "(00) 00000-0000",
                leadingIcon = Icons.Default.Phone,
                keyboardType = KeyboardType.Phone,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            // Address section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextField(
                    value = clinicaData.bairro,
                    onValueChange = { clinicaData = clinicaData.copy(bairro = it) },
                    label = "BAIRRO",
                    placeholder = "",
                    modifier = Modifier.weight(1f)
                )
                
                CustomTextField(
                    value = clinicaData.rua,
                    onValueChange = { clinicaData = clinicaData.copy(rua = it) },
                    label = "RUA",
                    placeholder = "",
                    modifier = Modifier.weight(1f)
                )
                
                CustomTextField(
                    value = clinicaData.numero,
                    onValueChange = { clinicaData = clinicaData.copy(numero = it) },
                    label = "Nº",
                    placeholder = "",
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.weight(0.5f)
                )
            }
            
            CustomTextField(
                value = clinicaData.cidade,
                onValueChange = { clinicaData = clinicaData.copy(cidade = it) },
                label = "CIDADE",
                placeholder = "",
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
}

@Preview(showBackground = true)
@Composable
fun ClinicaRegistrationScreenPreview() {
    ClinicaRegistrationScreen()
}