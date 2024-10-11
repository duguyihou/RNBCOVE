package com.rnbcove.modules

import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class VideoViewManager: SimpleViewManager<VideoView>() {
    override fun getName() = REACT_CLASS

    override fun createViewInstance(reactContext: ThemedReactContext): VideoView {
        return VideoView(reactContext)
    }

    override fun onAfterUpdateTransaction(view: VideoView) {
        super.onAfterUpdateTransaction(view)
        view.update()
    }

    @ReactProp(name = "source")
    fun setSource(view: VideoView, source: ReadableMap) {
        view.url = source.toHashMap()["url"] as? String
    }

    @ReactProp(name = "credentials")
    fun setCredentials(view: VideoView, source: ReadableMap) {
        view.accountId = source.toHashMap()["accountId"] as? String
        view.policyKey = source.toHashMap()["policyKey"] as? String
    }

    companion object {
        private const val REACT_CLASS = "VideoView"
    }
}
