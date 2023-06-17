package com.padm.ambigest.services.firebase.httpClient

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class HttpClientService {
    private val client = OkHttpClient()

    fun Get(url: String): String {
        val request = Request.Builder().url(url).build()

        client.newCall(request).execute().use { response ->
            if(!response.isSuccessful)
                throw IOException("Unexpected HTTP code: " + response.code)

            return response.body?.string() ?: throw IOException("Response body is null")
        }
    }

}