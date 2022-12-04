# MotionProgessLoader

:zap: A powerful & easy to use Progress Dialog for Android :zap:

![](https://cdn-images-1.medium.com/max/1600/0*3IokY5FD0deASOEZ.gif)


### Gradle Setup

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
  implementation 'com.github.ayushmaniac:MotionProgessLoader:1.3'
  
  //For compose
  implementation 'com.github.ayushmaniac.MotionProgessLoader:motionloadercompose:1.0.1'

}

```

### Implementation

```
  val motionProgressLoaderView = MotionProgressLoaderView.Builder(this)
            .setStayInLoop(true)
            .build()
    }
    
    // Addition of Custom Lottie
  val motionProgressLoaderView = MotionProgressLoaderView.Builder(requireContext())
            .setLottieAsset(drawableInt) // R.raw.lottieFiles
            .build()
    }
    
    
    //Compose Variant:
    
    @Composable
    fun HomeScreen() {
    val showDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                showDialog.value = !showDialog.value
            }
        )
        {
            Text(text = "Start Motion Loader")
            if (showDialog.value) {
                //customLottieAsset can be null in that case, a default loader will be rendered.
                MotionProgressLoader(customLottieAsset = R.raw.lol, false)
            }
        }
    }

}
```
