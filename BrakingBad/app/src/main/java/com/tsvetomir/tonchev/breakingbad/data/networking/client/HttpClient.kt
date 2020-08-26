package com.tsvetomir.tonchev.breakingbad.data.networking.client

import com.tsvetomir.tonchev.breakingbad.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class HttpClient {

    private val okHttpBuilder: OkHttpClient.Builder by lazy {
        OkHttpClient.Builder()
    }

    init {
        setDebugLevel()
    }

    fun get(): OkHttpClient {
        okHttpBuilder
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)
            .connectTimeout(BuildConfig.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(BuildConfig.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(BuildConfig.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)

        return okHttpBuilder.build()
    }

    private fun setDebugLevel() {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addNetworkInterceptor(logging)
    }

}