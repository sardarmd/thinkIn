package com.arolle.ullb.base.config

import android.app.Activity
import androidx.fragment.app.Fragment
import com.arolle.ullb.base.listeners.OnPhoneNumberValidListener
import com.arolle.ullb.base.listeners.OnSocialNetworkLoginListener

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
data class LoginConfig(
    val appId: String,
    val mode: LoginMode,
    var socialConfig: SocialNetworkConfig? = null,
    val phoneNumberConfig: PhoneNumberConfig? = null
)

data class PhoneNumberConfig(
    val countryCode: String,
    val phoneNumber: String,
    val phoneNumberValidListener: OnPhoneNumberValidListener,
    val waitTimeInMinutes: Int = 15,
    val maxRetry: Int = 5
)

data class SocialNetworkConfig(
    val component: Any,
    val socialNetworkType: SocialNetworkType,
    var socialId: String = ""
//    val socialNetworkLoginListener: OnSocialNetworkLoginListener
)

enum class LoginMode {
    PHONE_NUMBER_LOGIN, SOCIAL_NETWORK_LOGIN
}

enum class SocialNetworkType {
    FACEBOOK, TWITTER, INSTAGRAM, GOOGLE_PLUS
}


