package com.maniac.motionloadercompose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MotionProgressLoader(customLottieAsset : Int? = null, shouldStayInLoop : Boolean = true){
    Dialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        onDismissRequest = {},
    ){
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = Color.Transparent) {
            LottieContent(customLottieAsset, shouldStayInLoop)
        }
    }

}

@SuppressLint("SuspiciousIndentation")
@Composable
fun LottieContent(customLottieAsset: Int?, shouldStayInLoop: Boolean) {
 val composition by rememberLottieComposition(spec = getLottieSpecs(customLottieAsset))
    LottieAnimation(composition = composition, iterations = getIterations(shouldStayInLoop))
}

fun getIterations(shouldStayInLoop: Boolean): Int {
    return if(shouldStayInLoop) LottieConstants.IterateForever else 1
}

fun getLottieSpecs(customLottieAsset: Int?): LottieCompositionSpec {
    return customLottieAsset?.let {
        LottieCompositionSpec.RawRes(customLottieAsset)
    } ?: LottieCompositionSpec.RawRes(R.raw.loader)
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview(){
    MotionProgressLoader(null, true)
}