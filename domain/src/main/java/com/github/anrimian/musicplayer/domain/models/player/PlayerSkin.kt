package com.github.anrimian.musicplayer.domain.models.player

enum class PlayerSkin(
    val id: String,
    val storageCode: Int,
) {
    CLASSIC("classic", 0),
    POCKET_TAPE_84("pocket_tape_84", 1),
    ORBITAL("orbital", 2);

    companion object {
        @JvmStatic
        fun fromId(id: String?): PlayerSkin = values().firstOrNull { it.id == id } ?: CLASSIC

        @JvmStatic
        fun fromStorageCode(storageCode: Int): PlayerSkin =
            values().firstOrNull { it.storageCode == storageCode } ?: CLASSIC
    }
}
