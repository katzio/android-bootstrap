package todoapp.akatz.io.di

import dagger.Module
import dagger.Provides
import todoapp.akatz.io.repositories.UserRepository
import javax.inject.Singleton


@Module
class UserRepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository() = UserRepository()
}