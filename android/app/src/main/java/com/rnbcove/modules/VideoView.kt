package com.rnbcove.modules

import android.view.ViewGroup
import android.widget.FrameLayout
import com.brightcove.player.edge.Catalog
import com.brightcove.player.edge.VideoListener
import com.brightcove.player.event.EventType
import com.brightcove.player.model.Video
import com.brightcove.player.view.BrightcoveExoPlayerVideoView
import com.brightcove.ssai.SSAIComponent
import com.facebook.react.uimanager.ThemedReactContext

class VideoView(reactContext: ThemedReactContext) : BrightcoveExoPlayerVideoView(reactContext) {
    private var accountId = "5420904993001"
    private var policyKey =
        "BCpkADawqM3DwCTPGyMMiG0loem8lXox3utO1lFEP1i-_l1MpjRSVXMTSsa2ToslC129_W6YzwJpXbpbIVRFwf35qYM0pxo2HJK-_SotgmgrkmJTQ-024GkXIelVSY8LOHZzRBtcBU57M6Is"
    private val videoId = "5421538222001"
    private val baseUrl = "https://edge.api.brightcove.com/playback/v1"

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
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        eventEmitter?.on(EventType.DID_SET_SOURCE) {
            this.start()
        }
        initVideoByCatalog()
    }

    private fun initVideoByCatalog() {
        println("MainActivity - BCOV ---- initVideoByCatalog, find vide by id: $videoId, accountId: $accountId, policyKey: $policyKey")
        catalog = Catalog.Builder(eventEmitter, accountId)
            .setBaseURL(baseUrl)
            .setPolicy(policyKey)
            .build()

        catalog?.findVideoByID(videoId, object : VideoListener() {
            override fun onVideo(p0: Video?) {
                println("MainActivity - BCOV ----  onVideo $p0")
                if (p0 != null) {
                    this@VideoView.add(p0)
                }
            }
        })
    }
}