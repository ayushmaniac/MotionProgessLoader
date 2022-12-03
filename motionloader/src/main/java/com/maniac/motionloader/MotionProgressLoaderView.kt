package com.maniac.motionloader

import android.animation.ValueAnimator
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView

class MotionProgressLoaderView(
    context: Context?,
    private val lottieAsset: Int?,
    private val stayInLoop: Boolean
) :
    Dialog(context!!) {

    private var lottieView: LottieAnimationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_layout)
        lottieView = findViewById(R.id.lottieAnimationView)
        setBackgroundToTransparent()
        setCustomAnimation()
        stayInLoop()
    }

    private fun setBackgroundToTransparent() {
        window?.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    fun stopLoader() {
        this.hide()
    }

    fun startLoader() {
        this.show()
    }

    private fun setCustomAnimation() {
        lottieAsset?.let {
            lottieView?.setAnimation(it)
            lottieView?.playAnimation()
        }
    }

    fun isMotionLoaderRunning() = lottieView?.isAnimating

   private fun stayInLoop() {
        if (stayInLoop) {
            lottieView?.repeatCount = ValueAnimator.INFINITE
        } else {
            lottieView?.repeatCount = 0

        }
    }

    data class Builder(
        private val context : Context?,
    ){
        private var lottieAsset : Int? = null
        private var stayInLoop : Boolean = false

        fun setLottieAsset(lottieAsset : Int?) : Builder = apply { this.lottieAsset = lottieAsset }
        fun setStayInLoop(stayInLoop : Boolean) : Builder = apply { this.stayInLoop = stayInLoop }


        fun build() = MotionProgressLoaderView(context, lottieAsset, stayInLoop)
    }

}

