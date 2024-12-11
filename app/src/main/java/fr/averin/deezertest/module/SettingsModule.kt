package fr.averin.deezertest.module

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.averin.deezertest.repository.DataStoreThemeRepository
import fr.averin.deezertest.repository.ThemeRepository
import javax.inject.Singleton

val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "settings.user_settings"
)

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {

    @Binds
    @Singleton
    abstract fun bindThemeRepository(
        settingsRepository: DataStoreThemeRepository
    ): ThemeRepository

    companion object {

        @Provides
        @Singleton
        fun provideSettingsRepository(
            @ApplicationContext context: Context
        ): DataStore<Preferences> {
            return context.settingsDataStore
        }

    }

}