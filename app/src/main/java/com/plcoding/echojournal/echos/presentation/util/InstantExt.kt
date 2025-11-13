package com.plcoding.echojournal.echos.presentation.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun Instant.toReadableTime(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return this.atZone(ZoneId.systemDefault()).format(formatter)
}