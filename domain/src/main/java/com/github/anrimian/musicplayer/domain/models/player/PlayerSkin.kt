package com.github.anrimian.musicplayer.domain.models.player

enum class PlayerSkin(val id: String) {
    CLASSIC("classic"),
    POCKET_TAPE_84("pocket_tape_84"),
    ORBITAL("orbital");

    companion object {
        @JvmStatic
        fun fromId(id: String?): PlayerSkin = entries.firstOrNull { it.id == id } ?: CLASSIC
    }
}
