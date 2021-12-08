package com.arolle.ullb.sociallogin.core

import com.arolle.ullb.base.config.SocialNetworkConfig
import com.arolle.ullb.base.config.SocialNetworkType
import com.arolle.ullb.base.exceptions.ExceptionTypes
import com.arolle.ullb.base.exceptions.LoginException
import com.arolle.ullb.base.listeners.OnSocialNetworkLoginListener
import com.arolle.ullb.base.models.Person
import com.arolle.ullb.sociallogin.fb.FacebookHelper
import com.arolle.ullb.sociallogin.googleplus.GooglePlusHelper
import com.arolle.ullb.sociallogin.instagram.InstagramHelper
import com.arolle.ullb.sociallogin.listeners.FacebookListener
import com.arolle.ullb.sociallogin.listeners.GooglePlusListener
import com.arolle.ullb.sociallogin.listeners.InstagramListener
import com.arolle.ullb.sociallogin.listeners.TwitterListener
import com.arolle.ullb.sociallogin.twitter.TwitterHelper

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
class SocialNetworkManager private constructor(
    listener: OnSocialNetworkLoginListener


) : FacebookListener,
    TwitterListener, InstagramListener, GooglePlusListener {
    private lateinit var snListener: OnSocialNetworkLoginListener

    companion object {

        fun handleSocialLogin(
            config: SocialNetworkConfig, listener: OnSocialNetworkLoginListener
        ): SocialNetworkManager {
            val snManager = SocialNetworkManager(listener)
            when (config.socialNetworkType) {
                SocialNetworkType.FACEBOOK -> FacebookHelper(snManager, config.component)
                SocialNetworkType.GOOGLE_PLUS -> GooglePlusHelper(snManager)
                SocialNetworkType.INSTAGRAM -> InstagramHelper(snManager)
                SocialNetworkType.TWITTER -> TwitterHelper(snManager)
            }

            return snManager
        }
    }

    override fun onTwitterLoginSuccess() =
        snListener.onSocialNetworkLoginSuccess(Person("Sardar - onTwitterLoginSuccess"))

    override fun onTwitterLoginFail() = snListener.onSocialNetworkLoginFail(
        LoginException(
            "FBLoginFail",
            ExceptionTypes.TWITTER_EXCEPTION
        )
    )

    override fun onInstagramLoginSuccess() =
        snListener.onSocialNetworkLoginSuccess(Person("Sardar - onInstagramLoginSuccess"))

    override fun onInstagramLoginFail() = snListener.onSocialNetworkLoginFail(
        LoginException(
            "FBLoginFail",
            ExceptionTypes.INSTAGRAM_EXCEPTION
        )
    )

    override fun onGooglePlusLoginSuccess() =
        snListener.onSocialNetworkLoginSuccess(Person("Sardar - onGooglePlusLoginSuccess"))

    override fun onGooglePlusLoginFail() = snListener.onSocialNetworkLoginFail(
        LoginException(
            "FBLoginFail",
            ExceptionTypes.GOOGLE_EXCEPTION
        )
    )

    override fun onFacebookLoginSuccess(
        accessToken: String,
        firstName: String,
        secondName: String,
        profile: String,
        email: String
    ) {
        snListener.onSocialNetworkLoginSuccess(
            Person(
                name = firstName.plus(secondName),
                profilePic = profile,
                email = email
            )
        )
    }

    override fun onFacebookLoginFail(message: String) {
        LoginException(
            message,
            ExceptionTypes.FACEBOOK_EXCEPTION
        )
    }
}