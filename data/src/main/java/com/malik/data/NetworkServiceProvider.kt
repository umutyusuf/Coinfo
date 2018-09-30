package com.malik.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkServiceProvider @Inject
constructor(private val baseUrl: String, private val allowLogging: Boolean) {

    private val networkService: NetworkService

    init {
        networkService = buildNetworkService()
    }

    fun getNetworkService() = networkService

    private fun buildNetworkService(): NetworkService {
        val retrofit = provideRetrofit(getOkHttpClient())
        return retrofit.create(NetworkService::class.java)
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            with(Retrofit.Builder()) {
                baseUrl(baseUrl)
                client(okHttpClient)
                addConverterFactory(GsonConverterFactory.create())
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                build()
            }

    private fun getOkHttpClient(): OkHttpClient =
            with(OkHttpClient.Builder()) {
                connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                if (allowLogging)
                    addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                build()
            }

}