package com.rnbcove.modules

import com.brightcove.player.view.BrightcoveVideoView
import com.facebook.react.uimanager.ThemedReactContext

class VideoView(reactContext: ThemedReactContext) : BrightcoveVideoView(reactContext) {

    var url: String? = null
    var accountId: String? = null
    var policyKey: String? = null
    
    fun update() {
        println("🐵 ----  update")
    }
}