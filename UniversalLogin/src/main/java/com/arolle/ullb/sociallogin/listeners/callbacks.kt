package com.arolle.ullb.sociallogin.listeners

internal interface FacebookListener {
    fun onFacebookLoginSuccess()
    fun onFacebookLoginFail()
}

internal interface TwitterListener {
    fun onTwitterLoginSuccess()
    fun onTwitterLoginFail()
}

internal interface InstagramListener {
    fun onInstagramLoginSuccess()
    fun onInstagramLoginFail()
}

internal interface GooglePlusListener {
    fun onGooglePlusLoginSuccess()
    fun onGooglePlusLoginFail()
}