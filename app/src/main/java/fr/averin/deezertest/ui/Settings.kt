package fr.averin.deezertest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.averin.deezertest.ACCOUNT_SETTINGS
import fr.averin.deezertest.DISPLAY_SETTINGS
import fr.averin.deezertest.R
import fr.averin.deezertest.ui.theme.LightTextColor

@Composable
fun SettingsScreen(
    navigate: (String) -> Unit,
) {
    Scaffold { innerPadding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 15.dp)) {
            SettingSection(R.string.preferences) {
                SettingElement(
                    icon = Icons.Filled.Person,
                    title = R.string.account,
                    onClick = { navigate(ACCOUNT_SETTINGS) }
                )
                SettingElement(
                    icon = Icons.Filled.Visibility,
                    title = R.string.display,
                    onClick = { navigate(DISPLAY_SETTINGS) }
                )
            }
        }
    }
}

@Composable
fun SettingSection(
    title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            color = LightTextColor,
            style = MaterialTheme.typography.labelMedium
        )
        Column(
            Modifier
                .padding(vertical = 5.dp)
                .clip(RoundedCornerShape(7.dp))
                .background(MaterialTheme.colorScheme.surface)) {
            content()
        }
    }
}

@Composable
fun SettingElement(
    icon: ImageVector,
    title: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(Modifier.clickable { onClick() }) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = stringResource(id = title))
            Spacer(Modifier.width(10.dp))
            Text(stringResource(id = title))
            Spacer(Modifier.weight(1f))
            Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    Surface(Modifier.fillMaxSize()) {
        SettingsScreen {  }
    }
}

@Preview
@Composable
fun PreviewSettingElement() {
    SettingElement(Icons.Default.Settings, R.string.app_name, { })
}
