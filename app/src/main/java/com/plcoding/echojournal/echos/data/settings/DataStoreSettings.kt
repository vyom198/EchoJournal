package com.plcoding.echojournal.echos.data.settings

class DataStoreSettings(
    private val context: Context
): SettingsPreferences {

    companion object {
        private val Context.settingsDataStore by preferencesDataStore(
            name = "settings_datastore"
        )
    }

    private val topicsKey = stringSetPreferencesKey("topics")
    private val moodKey = stringPreferencesKey("mood")

    override suspend fun saveDefaultTopics(topics: List<String>) {
        context.settingsDataStore.edit { prefs ->
            prefs[topicsKey] = topics.toSet()
        }
    }

    override fun observeDefaultTopics(): Flow<List<String>> {
        return context
            .settingsDataStore
            .data
            .map { prefs ->
                prefs[topicsKey]?.toList() ?: emptyList()
            }
            .distinctUntilChanged()
    }

    override suspend fun saveDefaultMood(mood: Mood) {
        context.settingsDataStore.edit { prefs ->
            prefs[moodKey] = mood.name
        }
    }

    override fun observeDefaultMood(): Flow<Mood> {
        return context
            .settingsDataStore
            .data
            .map { prefs ->
                prefs[moodKey]?.let {
                    Mood.valueOf(it)
                } ?: Mood.NEUTRAL
            }
            .distinctUntilChanged()
    }
}