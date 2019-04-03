package todoapp.akatz.io.di

import dagger.Component
import todoapp.akatz.io.ToDoApplication
import todoapp.akatz.io.repositories.SharedPreferencesStore
import todoapp.akatz.io.repositories.UserRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (UserRepositoryModule::class)])
interface CoreComponent {
    fun inject(app: ToDoApplication)
    fun inject(app: UserRepository)
    fun inject(sharedPreferencesStore: SharedPreferencesStore)
}