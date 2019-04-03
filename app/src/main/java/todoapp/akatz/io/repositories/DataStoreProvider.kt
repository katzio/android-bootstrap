package todoapp.akatz.io.repositories

interface DataStoreProvider {
    fun dataStore(storageKey: String): DataStore
}