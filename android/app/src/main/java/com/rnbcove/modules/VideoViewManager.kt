package com.rnbcove.modules

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

class VideoViewManager: SimpleViewManager<VideoView>() {
    override fun getName() = REACT_CLASS

    override fun createViewInstance(reactContext: ThemedReactContext): VideoView {
        return VideoView(reactContext)
    }

    companion object {
        private const val REACT_CLASS = "VideoView"
    }
}
