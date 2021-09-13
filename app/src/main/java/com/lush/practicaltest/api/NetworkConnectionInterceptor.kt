package com.lush.practicaltest.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(/*context: Context*/) : Interceptor {

    //private val mContext: Context = context

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        /*if (!isInternetAvailable(mContext)) {
            throw NoConnectivityException()
            // Throwing our custom exception 'NoConnectivityException'
        }*/
        val builder: Request.Builder =
            chain.request().newBuilder()

        val response = chain.proceed(builder.build())

        when (response.code) {
            404 -> {
                throw NoConnectivityException()
            }
            503 -> {
                throw NoConnectivityException()
            }
            else -> {
                return response
            }
        }
    }
}