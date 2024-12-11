package fr.averin.deezertest

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import fr.averin.deezertest.ui.AccountSettingsScreen
import fr.averin.deezertest.ui.DisplaySettingsScreen
import fr.averin.deezertest.ui.SettingsScreen

fun NavGraphBuilder.appRoutes(navController: NavController) {
    composable(SETTINGS) { SettingsScreen { navController.navigate(it) } }
    composable(DISPLAY_SETTINGS) { DisplaySettingsScreen({ navController.popBackStack() }) }
    composable(ACCOUNT_SETTINGS) { AccountSettingsScreen({ navController.popBackStack() }) }
}

const val SETTINGS = "settings"
const val DISPLAY_SETTINGS = "settings/display"
const val ACCOUNT_SETTINGS = "settings/account"
