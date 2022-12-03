package com.maniac.loader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.maniac.motionloader.MotionProgressLoaderView

class MainActivity : AppCompatActivity() {

    private var button: Button? = null
    private var motionProgressLoaderView: MotionProgressLoaderView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        buildProgressLoader()
        setButtonClickListener()
    }

    private fun buildProgressLoader() {
        motionProgressLoaderView = MotionProgressLoaderView.Builder(this)
            .setLottieAsset(R.raw.lol)
            .setStayInLoop(true)
            .build()
    }

    private fun initView() {
        button = findViewById(R.id.startStop)
    }

    private fun setButtonClickListener() {
        button?.setOnClickListener {
            if (motionProgressLoaderView?.isMotionLoaderRunning() == true) {
                motionProgressLoaderView?.stopLoader()
            } else {
                motionProgressLoaderView?.startLoader()
            }
        }
    }
}

