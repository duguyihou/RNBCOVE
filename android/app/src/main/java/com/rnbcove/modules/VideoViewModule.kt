package com.rnbcove.modules

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule

class VideoViewModule(context: ReactApplicationContext) :
    ReactContextBaseJavaModule(context) {

    override fun getName(): String = REACT_CLASS

    companion object {
        private const val REACT_CLASS = "VideoViewManager"
    }
}