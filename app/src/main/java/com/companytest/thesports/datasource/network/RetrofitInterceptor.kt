package com.companytest.thesports.datasource.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RetrofitInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val connection = chain.connection()
        val requestStartMessage =
            ("--> ${request.method()} ${request.url()} ${if (connection != null) connection.protocol() else " "}")

        Log.i("interceptor", requestStartMessage)

        val response = chain.proceed(request)
        val responseBody = response.body()
        var contentLength: Long = 0
        if (responseBody != null) {
            contentLength = responseBody.contentLength()
        }
        val bodySize = if (contentLength != -1L) "$contentLength-byte" else "unknown-length"
        val message = "<-- " + response.code() + (if (response.message()
                .isEmpty()
        ) "" else ' ' + response.message()) + ' '.toString() + response.request()
            .url() + " (" + 0 + "ms" + ", $bodySize body" + ')'.toString()
        Log.d("interceptor", message)

        return response
    }

}