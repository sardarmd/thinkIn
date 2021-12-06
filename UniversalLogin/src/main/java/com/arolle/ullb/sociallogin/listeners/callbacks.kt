package com.arolle.ullb.sociallogin.listeners
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
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