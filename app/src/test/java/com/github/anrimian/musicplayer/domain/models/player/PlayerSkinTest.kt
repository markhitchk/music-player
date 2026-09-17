package com.github.anrimian.musicplayer.domain.models.player

import org.junit.Assert.assertEquals
import org.junit.Test

class PlayerSkinTest {

    @Test
    fun `null id falls back to classic`() {
        assertEquals(PlayerSkin.CLASSIC, PlayerSkin.fromId(null))
    }

    @Test
    fun `unknown id falls back to classic`() {
        assertEquals(PlayerSkin.CLASSIC, PlayerSkin.fromId("future_skin_that_does_not_exist"))
    }

    @Test
    fun `known ids resolve to matching skin`() {
        assertEquals(PlayerSkin.CLASSIC, PlayerSkin.fromId("classic"))
        assertEquals(PlayerSkin.POCKET_TAPE_84, PlayerSkin.fromId("pocket_tape_84"))
        assertEquals(PlayerSkin.ORBITAL, PlayerSkin.fromId("orbital"))
    }

    @Test
    fun `unknown storage code falls back to classic`() {
        assertEquals(PlayerSkin.CLASSIC, PlayerSkin.fromStorageCode(-1))
        assertEquals(PlayerSkin.CLASSIC, PlayerSkin.fromStorageCode(999))
    }

    @Test
    fun `skin identifiers and storage codes remain stable`() {
        assertEquals("classic", PlayerSkin.CLASSIC.id)
        assertEquals(0, PlayerSkin.CLASSIC.storageCode)
        assertEquals("pocket_tape_84", PlayerSkin.POCKET_TAPE_84.id)
        assertEquals(1, PlayerSkin.POCKET_TAPE_84.storageCode)
        assertEquals("orbital", PlayerSkin.ORBITAL.id)
        assertEquals(2, PlayerSkin.ORBITAL.storageCode)
    }
}
