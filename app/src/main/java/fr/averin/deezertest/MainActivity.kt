package fr.averin.deezertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.averin.deezertest.repository.Theme
import fr.averin.deezertest.ui.theme.DeezerTestTheme
import fr.averin.deezertest.viewmodel.ThemeViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    DeezerTestTheme(
        darkTheme = themeViewModel.getTheme() == Theme.DARK
    ) {
        Surface( modifier = Modifier.fillMaxSize() ) {
            val navController = rememberNavController()

            NavHost(
                navController,
                startDestination = SETTINGS,
                modifier = Modifier.padding()
            ) {
                appRoutes(navController)
            }
        }
    }

    LaunchedEffect(themeViewModel) {
        themeViewModel.fetchTheme()
    }
}
