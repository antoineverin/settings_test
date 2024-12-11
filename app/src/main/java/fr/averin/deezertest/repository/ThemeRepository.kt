package fr.averin.deezertest.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

enum class Theme {
    DARK,
    LIGHT,
}

interface ThemeRepository {

    suspend fun getTheme(): Theme

    suspend fun setTheme(theme: Theme)

}

class DataStoreThemeRepository @Inject constructor(
    private val settingsPreferencesStore: DataStore<Preferences>
) : ThemeRepository {

    override suspend fun getTheme(): Theme {
        val flow = settingsPreferencesStore.data
            .map { preferences ->
                Theme.valueOf(preferences[THEME_KEY] ?: Theme.LIGHT.name)
            }
        return flow.first()
    }

    override suspend fun setTheme(theme: Theme) {
        settingsPreferencesStore.edit { preferences ->
            preferences[THEME_KEY] = theme.name
        }
    }

    private companion object {
        val THEME_KEY = stringPreferencesKey(name = "theme")
    }

}
