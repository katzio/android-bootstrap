package todoapp.akatz.io.di

import android.content.Context
import dagger.Module
import dagger.Provides
import todoapp.akatz.io.ToDoApplication
import todoapp.akatz.io.repositories.DataStoreProvider
import javax.inject.Singleton


@Module
class AppModule(private val app: ToDoApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context = app

    @Provides
    @Singleton
    fun providesDataStoreProvider(): DataStoreProvider = app
}