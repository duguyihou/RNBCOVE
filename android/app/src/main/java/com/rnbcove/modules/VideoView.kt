package com.rnbcove.modules

import android.view.ViewGroup
import android.widget.FrameLayout
import com.brightcove.player.display.ExoPlayerVideoDisplayComponent
import com.brightcove.player.edge.Catalog
import com.brightcove.player.edge.VideoListener
import com.brightcove.player.event.EventType
import com.brightcove.player.model.Video
import com.brightcove.player.view.BrightcoveExoPlayerVideoView
import com.brightcove.ssai.SSAIComponent
import com.facebook.react.uimanager.ThemedReactContext

class VideoView(reactContext: ThemedReactContext) : BrightcoveExoPlayerVideoView(reactContext) {

    var url: String? = null
    var accountId: String? = null
    var policyKey: String? = null
    var videoId: String? = null
    private var plugin: SSAIComponent? = null

    private var catalog: Catalog? = null

    init {
        init(reactContext)
        this.finishInitialization()

        this.layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        plugin = SSAIComponent(reactContext, this)
        mediaController = null


        //initialize BC listeners so that we can perform actions on videos and ads based on the events from BC sdk
        this.initListeners()
    }

    fun update() {
        println("🐵 ----  update")

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        println("🐵 ----  onAttachedToWindow ${this.eventEmitter}")
        eventEmitter?.on(EventType.DID_SET_SOURCE) {
            println("🐵 ----  event ${it.type}")
            this.start()
        }
//        if (videoId != null) {
        initVideoByCatalog(videoId!!)
//        }
    }


    private fun initVideoByCatalog(videoId: String) {
        println("🐵 ---- initVideoByCatalog ")
        if (accountId != null && policyKey != null) {
            catalog = Catalog.Builder(eventEmitter, accountId!!).setPolicy(policyKey!!).build()
            catalog?.findVideoByID(videoId, object : VideoListener() {
                override fun onVideo(p0: Video?) {
                    println("🐵 ----  onVideo $p0")
                    if (p0 != null) {
                        plugin?.processVideo(p0)
                        val exo = (getVideoDisplay() as? ExoPlayerVideoDisplayComponent)?.exoPlayer
                        println("🐵 ----  exo $exo")
                        exo?.playWhenReady = true
                    }
                }
            })

        }
    }
}