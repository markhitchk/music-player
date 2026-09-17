package com.github.anrimian.musicplayer.ui.player_screen.skin

import android.content.Context
import android.content.SharedPreferences
import com.github.anrimian.musicplayer.domain.models.player.PlayerSkin

class PlayerSkinPreferences(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences(
        PREFERENCES_NAME,
        Context.MODE_PRIVATE,
    )

    var selectedSkin: PlayerSkin
        get() = PlayerSkin.fromStorageCode(
            preferences.getInt(KEY_SELECTED_SKIN, PlayerSkin.CLASSIC.storageCode)
        )
        set(value) {
            preferences.edit().putInt(KEY_SELECTED_SKIN, value.storageCode).apply()
        }

    fun registerListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        preferences.registerOnSharedPreferenceChangeListener(listener)
    }

    fun unregisterListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        preferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    companion object {
        private const val PREFERENCES_NAME = "player_skin_preferences"
        const val KEY_SELECTED_SKIN = "selected_player_skin"
    }
}
