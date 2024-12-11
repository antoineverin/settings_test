package fr.averin.deezertest.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.averin.deezertest.repository.DemoUserRepository
import fr.averin.deezertest.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    fun provideUserRepository(): UserRepository {
        return DemoUserRepository()
    }

}