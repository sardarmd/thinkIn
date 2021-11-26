package com.arolle.ullb.sociallogin.listeners

interface FacebookListener {
    fun onFacebookLoginSuccess()
    fun onFacebookLoginFail()
}

interface TwitterListener {
    fun onTwitterLoginSuccess()
    fun onTwitterLoginFail()
}

interface InstagramListener {
    fun onInstagramLoginSuccess()
    fun onInstagramLoginFail()
}

interface GooglePlusListener {
    fun onGooglePlusLoginSuccess()
    fun onGooglePlusLoginFail()
}