package fr.averin.deezertest.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.averin.deezertest.repository.Theme
import fr.averin.deezertest.repository.ThemeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themeRepository: ThemeRepository
): ViewModel() {

    companion object {
        private val theme = mutableStateOf(Theme.LIGHT)
    }

    fun setTheme(theme: Theme) {
        ThemeViewModel.theme.value = theme
        saveTheme()
    }

    fun getTheme(): Theme {
        return theme.value
    }

    private fun saveTheme() {
        viewModelScope.launch {
            themeRepository.setTheme(theme.value)
        }
    }

    fun fetchTheme() {
        viewModelScope.launch {
            theme.value = themeRepository.getTheme()
        }
    }

}
