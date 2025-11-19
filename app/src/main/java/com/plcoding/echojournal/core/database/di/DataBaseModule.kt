package com.plcoding.echojournal.core.database.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import kotlin.jvm.java

val databaseModule = module {
    single<EchoDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            EchoDatabase::class.java,
            "echos.db",
        ).build()
    }
    single {
        get<EchoDatabase>().echoDao
    }
}