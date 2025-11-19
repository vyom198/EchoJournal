package com.plcoding.echojournal.echos.domain.audio

import android.media.AudioTrack
import kotlinx.coroutines.flow.StateFlow


interface AudioPlayer {
    val activeTrack: StateFlow<com.plcoding.echojournal.echos.domain.audio.AudioTrack?>
    fun play(filePath: String, onComplete: () -> Unit)
    fun pause()
    fun resume()
    fun stop()
}