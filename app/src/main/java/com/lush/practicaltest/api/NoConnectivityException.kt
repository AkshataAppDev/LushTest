package com.lush.practicaltest.api

import java.io.IOException



class NoConnectivityException : IOException() {

    override val message: String
        get() = "No Internet Connection"
    // You can send any message whatever you want from here.
}