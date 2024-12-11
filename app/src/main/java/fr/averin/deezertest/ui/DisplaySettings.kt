package fr.averin.deezertest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import fr.averin.deezertest.R
import fr.averin.deezertest.repository.Theme
import fr.averin.deezertest.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplaySettingsScreen(
    popUp: () -> Unit,
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(stringResource(R.string.display)) },
            navigationIcon = {
                IconButton(onClick = popUp) {
                    Icon(
                        Icons.Filled.ChevronLeft,
                        contentDescription = null
                    )
                }
            }
        )
    }) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(15.dp, 20.dp)
                .fillMaxWidth()) {
            SettingOptionSwitch(
                title = R.string.enable_dark_theme,
                checked = themeViewModel.getTheme() == Theme.DARK
            ) { themeViewModel.setTheme(if (it) Theme.DARK else Theme.LIGHT) }
        }
    }
}

@Composable
fun SettingOptionSwitch(
    title: Int,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Box(
        Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(stringResource(title))
            Switch(checked, onCheckedChange)
        }
    }
}

@Preview
@Composable
fun DisplaySettingsScreenPreview() {
    DisplaySettingsScreen({ })
}

@Preview
@Composable
fun SettingOptionSwitchPreview() {
    SettingOptionSwitch(R.string.app_name, true) { }
}
