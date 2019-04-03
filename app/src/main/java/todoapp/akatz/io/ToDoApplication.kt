package todoapp.akatz.io

import android.app.Application
import todoapp.akatz.io.di.AppModule
import todoapp.akatz.io.di.CoreComponent
import todoapp.akatz.io.di.DaggerCoreComponent
import todoapp.akatz.io.di.UserRepositoryModule
import todoapp.akatz.io.repositories.DataStore
import todoapp.akatz.io.repositories.DataStoreProvider
import todoapp.akatz.io.repositories.SharedPreferencesStore
import todoapp.akatz.io.repositories.UserRepository
import javax.inject.Inject

class ToDoApplication : Application(), DataStoreProvider {

    @Inject
    lateinit var userRepository: UserRepository

    companion object {
        @JvmStatic
        lateinit var coreComponent: CoreComponent
    }

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder()
            .appModule(AppModule(this))
            .userRepositoryModule(UserRepositoryModule())
            .build()
        coreComponent.inject(this)
        userRepository.isFreshInstall = false
    }

    override fun dataStore(storageKey: String): DataStore {
        return SharedPreferencesStore(storageKey)
    }
}