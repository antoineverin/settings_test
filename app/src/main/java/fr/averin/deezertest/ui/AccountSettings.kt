package fr.averin.deezertest.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import fr.averin.deezertest.R
import fr.averin.deezertest.ui.theme.LightTextColor
import fr.averin.deezertest.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSettingsScreen(
    popUp: () -> Unit,
    userViewModel: UserViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(stringResource(R.string.account)) },
            navigationIcon = {
                IconButton(onClick = popUp) {
                    Icon(
                        Icons.Filled.ChevronLeft,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            },
        )
    }) { innerPadding ->
        Column(Modifier.padding(innerPadding).padding(horizontal = 20.dp)) {
            Box(Modifier.fillMaxWidth().padding(vertical = 20.dp), contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = userViewModel.getProfilePictureUrl(),
                    contentDescription = stringResource(R.string.profile_picture),
                    modifier = Modifier.clip(RoundedCornerShape(100)).size(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = userViewModel.getUsername(),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${userViewModel.getFollowers()} ${stringResource(R.string.followers)} | ${userViewModel.getFollowings()} ${stringResource(R.string.followings)}",
                color = LightTextColor,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview
@Composable
fun AccountSettingsScreenPreview() {
    AccountSettingsScreen({  })
}
