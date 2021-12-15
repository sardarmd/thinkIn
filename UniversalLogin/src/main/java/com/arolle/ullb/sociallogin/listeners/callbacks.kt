package com.arolle.ullb.sociallogin.listeners

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
  interface FacebookListener {
    fun onFacebookLoginSuccess(
        accessToken: String = "",
        firstName: String = "",
        secondName: String = "",
        profile: String = "",
        email:String =""
    )

    fun onFacebookLoginFail(message: String)
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