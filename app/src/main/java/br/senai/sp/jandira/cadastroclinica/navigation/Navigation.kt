package br.senai.sp.jandira.cadastroclinica.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.cadastroclinica.screens.*

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ResponsavelRegistration : Screen("responsavel_registration")
    object BebeRegistration : Screen("bebe_registration")
    object MedicoRegistration : Screen("medico_registration")
    object ClinicaRegistration : Screen("clinica_registration")
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToResponsavel = {
                    navController.navigate(Screen.ResponsavelRegistration.route)
                },
                onNavigateToBebe = {
                    navController.navigate(Screen.BebeRegistration.route)
                },
                onNavigateToMedico = {
                    navController.navigate(Screen.MedicoRegistration.route)
                },
                onNavigateToClinica = {
                    navController.navigate(Screen.ClinicaRegistration.route)
                }
            )
        }
        
        composable(Screen.ResponsavelRegistration.route) {
            ResponsavelRegistrationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNext = {
                    navController.navigate(Screen.BebeRegistration.route)
                }
            )
        }
        
        composable(Screen.BebeRegistration.route) {
            BebeRegistrationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onSave = {
                    navController.popBackStack(Screen.Home.route, false)
                }
            )
        }
        
        composable(Screen.MedicoRegistration.route) {
            MedicoRegistrationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onSave = {
                    navController.popBackStack(Screen.Home.route, false)
                }
            )
        }
        
        composable(Screen.ClinicaRegistration.route) {
            ClinicaRegistrationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onSave = {
                    navController.popBackStack(Screen.Home.route, false)
                }
            )
        }
    }
}
