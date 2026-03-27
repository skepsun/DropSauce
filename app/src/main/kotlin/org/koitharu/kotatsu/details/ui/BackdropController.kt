package org.koitharu.kotatsu.details.ui

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import coil3.ImageLoader
import coil3.request.ImageRequest
import coil3.request.lifecycle

class BackdropController(
	private val backdrop: ImageView,
	private val backdropGradient: View,
	private val backdropTopGradient: View,
	private val context: Context,
	private val imageLoader: ImageLoader,
	private val lifecycle: LifecycleOwner,
) {

	fun load(imageUrl: String?) {
		if (imageUrl == null) {
			hide()
			return
		}
		val request = ImageRequest.Builder(context)
			.data(imageUrl)
			.lifecycle(lifecycle)
			.target(backdrop)
			.build()
		imageLoader.enqueue(request)
		backdrop.isVisible = true
		backdropGradient.isVisible = true
		backdropTopGradient.isVisible = true
	}

	fun setTranslationY(y: Float) {
		backdrop.translationY = y
		backdropGradient.translationY = y
		backdropTopGradient.translationY = y
	}

	fun hide() {
		backdrop.isGone = true
		backdropGradient.isGone = true
		backdropTopGradient.isGone = true
	}
}
