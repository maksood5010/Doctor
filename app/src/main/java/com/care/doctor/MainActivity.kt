package com.care.doctor

import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
		windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
		window.decorView.setOnApplyWindowInsetsListener { view, windowInsets ->
			windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
			view.onApplyWindowInsets(windowInsets)
		}

		val pulse: Animation = AnimationUtils.loadAnimation(this, R.anim.heart_pulse)
		findViewById<TextView>(R.id.tvTokenNumber).startAnimation(pulse)
	}
}