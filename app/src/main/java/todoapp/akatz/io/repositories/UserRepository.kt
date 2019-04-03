package todoapp.akatz.io.repositories

import todoapp.akatz.io.ToDoApplication
import javax.inject.Inject

private const val USER_CACHE_NAME = "todo.app.user"

private const val IS_FRESH_INSTALL = "is_fresh_install"

class UserRepository {

    @Inject
    lateinit var dataStoreProvider: DataStoreProvider

    private var userDataStore: DataStore

    init {
        ToDoApplication.coreComponent.inject(this)
        userDataStore = dataStoreProvider.dataStore(USER_CACHE_NAME)
    }

    var isFreshInstall: Boolean
        set(freshInstall) = userDataStore.putBoolean(IS_FRESH_INSTALL, freshInstall)
        get() = userDataStore.getBoolean(IS_FRESH_INSTALL, true)
}