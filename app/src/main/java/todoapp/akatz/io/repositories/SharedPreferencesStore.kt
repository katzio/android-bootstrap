package todoapp.akatz.io.repositories

import android.content.Context
import todoapp.akatz.io.ToDoApplication
import javax.inject.Inject

class SharedPreferencesStore(private val storageSection: String) : DataStore {
    private val UTF8_CHARSET = "UTF-8"

    init {
        ToDoApplication.coreComponent.inject(this)
    }

    @Inject
    lateinit var applicationContext: Context

    override fun getBoolean(key: String, value: Boolean): Boolean {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        return sp.getBoolean(key, value)
    }

    override fun putBoolean(key: String, value: Boolean) {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        return sp.getInt(key, defaultValue)
    }

    override fun putInt(key: String, value: Int) {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        return sp.getLong(key, defaultValue)
    }

    override fun putLong(key: String, value: Long) {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    override fun getString(key: String, defaultValue: String): String {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        return sp.getString(key, defaultValue)
    }

    override fun getStringList(key: String, defaultValue: List<String>): List<String> {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        val set = sp.getStringSet(key, null)
        return if (set == null) defaultValue else ArrayList(set)
    }

    override fun putString(key: String, value: String) {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun putStringList(key: String, value: List<String>?) {
        if (value != null) {
            val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
            val editor = sp.edit()
            val temp = HashSet(value)
            editor.putStringSet(key, temp)
            editor.apply()
        }
    }

    override fun clear(key: String) {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove(key)
        editor.apply()
    }

    override fun clearAll() {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.clear()
        editor.apply()
    }

    override fun getAll(): Map<String, *> {
        val sp = applicationContext.getSharedPreferences(storageSection, Context.MODE_PRIVATE)
        return sp.all
    }
}