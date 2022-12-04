# MotionProgessLoader

:zap: A powerful & easy to use Progress Dialog for Android :zap:


### Gradle Setup

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
  implementation 'com.github.ayushmaniac:MotionProgessLoader:1.3'
}
```

### Implementation

```
  val motionProgressLoaderView = MotionProgressLoaderView.Builder(this)
            .setStayInLoop(true)
            .build()
    }
```

## Custom Lottie
```
 val motionProgressLoaderView = MotionProgressLoaderView.Builder(requireContext())
            .setLottieAsset(drawableInt) // R.raw.lottieFiles
            .build()
    }
```
