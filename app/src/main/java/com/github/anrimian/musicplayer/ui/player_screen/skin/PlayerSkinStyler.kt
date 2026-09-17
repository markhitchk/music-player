package com.github.anrimian.musicplayer.ui.player_screen.skin

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.github.anrimian.musicplayer.R
import com.github.anrimian.musicplayer.databinding.PartialControlPanelBinding
import com.github.anrimian.musicplayer.domain.models.player.PlayerSkin
import com.google.android.material.shape.ShapeAppearanceModel

class PlayerSkinStyler(
    private val root: View,
    private val binding: PartialControlPanelBinding,
) {

    private val classicRootBackground: Drawable? = root.background
    private val classicCoverBackground: Drawable? = binding.flCoverWrapper.background
    private val classicCoverShape = binding.ivCover.shapeAppearanceModel
    private val classicTitleColors = binding.tvCurrentComposition.textColors
    private val classicArtistColors = binding.tvCurrentCompositionArtist.textColors
    private val classicPlayedTimeColors = binding.tvPlayedTime.textColors
    private val classicTotalTimeColors = binding.tvTotalTime.textColors
    private val classicSpeedColors = binding.tvPlaybackSpeed.textColors
    private val classicVolumeColors = binding.tvVolume.textColors
    private val classicSleepColors = binding.tvSleepTime.textColors
    private val classicPreviousTint = binding.ivSkipToPrevious.imageTintList
    private val classicPlayPauseTint = binding.ivPlayPause.imageTintList
    private val classicNextTint = binding.ivSkipToNext.imageTintList
    private val classicRandomTint = binding.btnRandomMode.imageTintList
    private val classicRepeatTint = binding.btnRepeatMode.imageTintList
    private val classicIndicatorTint = binding.ivBottomPanelIndicator.imageTintList
    private val classicSeekProgressTint = binding.sbTrackState.progressTintList
    private val classicSeekThumbTint = binding.sbTrackState.thumbTintList

    fun apply(skin: PlayerSkin) {
        when (skin) {
            PlayerSkin.CLASSIC -> applyClassic()
            PlayerSkin.POCKET_TAPE_84 -> applyPocketTape()
            PlayerSkin.ORBITAL -> applyOrbital()
        }
    }

    private fun applyClassic() {
        root.background = classicRootBackground
        binding.flCoverWrapper.background = classicCoverBackground
        binding.ivCover.shapeAppearanceModel = classicCoverShape
        binding.ivCover.scaleX = 1f
        binding.ivCover.scaleY = 1f
        binding.ivCover.alpha = 1f

        binding.tvCurrentComposition.setTextColor(classicTitleColors)
        binding.tvCurrentCompositionArtist.setTextColor(classicArtistColors)
        binding.tvPlayedTime.setTextColor(classicPlayedTimeColors)
        binding.tvTotalTime.setTextColor(classicTotalTimeColors)
        binding.tvPlaybackSpeed.setTextColor(classicSpeedColors)
        binding.tvVolume.setTextColor(classicVolumeColors)
        binding.tvSleepTime.setTextColor(classicSleepColors)

        binding.ivSkipToPrevious.imageTintList = classicPreviousTint
        binding.ivPlayPause.imageTintList = classicPlayPauseTint
        binding.ivSkipToNext.imageTintList = classicNextTint
        binding.btnRandomMode.imageTintList = classicRandomTint
        binding.btnRepeatMode.imageTintList = classicRepeatTint
        binding.ivBottomPanelIndicator.imageTintList = classicIndicatorTint
        binding.sbTrackState.progressTintList = classicSeekProgressTint
        binding.sbTrackState.thumbTintList = classicSeekThumbTint
    }

    private fun applyPocketTape() {
        val background = color(R.color.player_skin_pocket_background)
        val surface = color(R.color.player_skin_pocket_surface)
        val primary = color(R.color.player_skin_pocket_primary)
        val secondary = color(R.color.player_skin_pocket_secondary)
        val accent = color(R.color.player_skin_pocket_accent)

        root.background = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(surface, background, background),
        )
        binding.flCoverWrapper.background = outlinedSurface(surface, accent, 10f)
        binding.ivCover.shapeAppearanceModel = roundedShape(8f)
        binding.ivCover.scaleX = 0.92f
        binding.ivCover.scaleY = 0.92f
        binding.ivCover.alpha = 0.9f

        applyTextColors(primary, secondary)
        applyControlTint(accent)
    }

    private fun applyOrbital() {
        val background = color(R.color.player_skin_orbital_background)
        val surface = color(R.color.player_skin_orbital_surface)
        val primary = color(R.color.player_skin_orbital_primary)
        val secondary = color(R.color.player_skin_orbital_secondary)
        val accent = color(R.color.player_skin_orbital_accent)

        root.background = GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            intArrayOf(surface, background, background),
        )
        binding.flCoverWrapper.background = outlinedSurface(surface, accent, 999f)
        binding.ivCover.shapeAppearanceModel = roundedShape(999f)
        binding.ivCover.scaleX = 0.9f
        binding.ivCover.scaleY = 0.9f
        binding.ivCover.alpha = 0.96f

        applyTextColors(primary, secondary)
        applyControlTint(accent)
    }

    private fun applyTextColors(primary: Int, secondary: Int) {
        binding.tvCurrentComposition.setTextColor(primary)
        binding.tvCurrentCompositionArtist.setTextColor(secondary)
        binding.tvPlayedTime.setTextColor(secondary)
        binding.tvTotalTime.setTextColor(secondary)
        binding.tvPlaybackSpeed.setTextColor(secondary)
        binding.tvVolume.setTextColor(secondary)
        binding.tvSleepTime.setTextColor(secondary)
    }

    private fun applyControlTint(accent: Int) {
        val tint = ColorStateList.valueOf(accent)
        binding.ivSkipToPrevious.imageTintList = tint
        binding.ivPlayPause.imageTintList = tint
        binding.ivSkipToNext.imageTintList = tint
        binding.btnRandomMode.imageTintList = tint
        binding.btnRepeatMode.imageTintList = tint
        binding.ivBottomPanelIndicator.imageTintList = tint
        binding.sbTrackState.progressTintList = tint
        binding.sbTrackState.thumbTintList = tint
    }

    private fun outlinedSurface(fill: Int, stroke: Int, cornerDp: Float): Drawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setColor(fill)
            cornerRadius = dp(cornerDp)
            setStroke(dp(1f).toInt().coerceAtLeast(1), stroke)
        }
    }

    private fun roundedShape(cornerDp: Float): ShapeAppearanceModel {
        return ShapeAppearanceModel.builder()
            .setAllCornerSizes(dp(cornerDp))
            .build()
    }

    private fun dp(value: Float): Float = value * root.resources.displayMetrics.density

    private fun color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(root.context, colorRes)
}
