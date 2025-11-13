package br.senai.sp.jandira.cadastroclinica.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.cadastroclinica.components.*
import br.senai.sp.jandira.cadastroclinica.model.ResponsavelData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResponsavelRegistrationScreen(
    onNavigateBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    var responsavelData by remember { mutableStateOf(ResponsavelData()) }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Header
        RegistrationHeader(
            title = "Cadastro do Responsável",
            subtitle = "Responsável",
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
                value = responsavelData.nomeCompleto,
                onValueChange = { responsavelData = responsavelData.copy(nomeCompleto = it) },
                label = "Nome completo",
                placeholder = "Digite o nome completo",
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = responsavelData.dataDeNascimento,
                onValueChange = { responsavelData = responsavelData.copy(dataDeNascimento = it) },
                label = "Data de nascimento",
                placeholder = "Selecione a data",
                leadingIcon = Icons.Default.DateRange,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = responsavelData.cpf,
                onValueChange = { responsavelData = responsavelData.copy(cpf = it) },
                label = "CPF",
                placeholder = "000.000.000-00",
                keyboardType = KeyboardType.Number,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = responsavelData.telefone,
                onValueChange = { responsavelData = responsavelData.copy(telefone = it) },
                label = "TELEFONE",
                placeholder = "(00) 00000-0000",
                leadingIcon = Icons.Default.Phone,
                keyboardType = KeyboardType.Phone,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = responsavelData.email,
                onValueChange = { responsavelData = responsavelData.copy(email = it) },
                label = "EMAIL",
                placeholder = "exemplo@email.com",
                leadingIcon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            CustomTextField(
                value = responsavelData.cep,
                onValueChange = { responsavelData = responsavelData.copy(cep = it) },
                label = "CEP",
                placeholder = "CEP",
                leadingIcon = Icons.Default.LocationOn,
                keyboardType = KeyboardType.Number,
                isRequired = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            // Checkbox for second responsible
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = responsavelData.adicionarSegundoResponsavel,
                    onCheckedChange = { 
                        responsavelData = responsavelData.copy(adicionarSegundoResponsavel = it) 
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF6366F1)
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Adicionar segundo responsável",
                    color = Color.Black
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .width(110.dp)
                    .height(40.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFF6366F1),
                    contentColor = Color.White
                ),
                border = BorderStroke(width = 0.5.dp, color = Color.White)

            ) {
                Text(
                    text = "PRÓXIMO",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ResponsavelcreenPreview() {
    ResponsavelRegistrationScreen()
}