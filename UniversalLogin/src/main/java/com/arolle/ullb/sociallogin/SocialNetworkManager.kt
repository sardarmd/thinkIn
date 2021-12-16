package com.arolle.ullb.sociallogin

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.common.SocialNetworkConfig
import com.arolle.ullb.common.SocialNetworkType
import com.arolle.ullb.common.di.components.social.DaggerSocialComponentProvider
import com.arolle.ullb.common.exceptions.ExceptionTypes
import com.arolle.ullb.common.exceptions.LoginException
import com.arolle.ullb.common.listeners.*
import com.arolle.ullb.common.models.Person
import com.arolle.ullb.common.di.modules.social.FacebookModule
import com.arolle.ullb.common.di.modules.social.SocialNetworkModule
import com.arolle.ullb.sociallogin.fb.FacebookHelper
import com.arolle.ullb.sociallogin.googleplus.GooglePlusHelper
import com.arolle.ullb.sociallogin.instagram.InstagramHelper
import com.arolle.ullb.sociallogin.twitter.TwitterHelper
import javax.inject.Inject
import javax.inject.Named

class SocialNetworkManager(private val config: SocialNetworkConfig, private val listener: OnSocialNetworkLoginListener) :
        FacebookListener,
        TwitterListener, InstagramListener, GooglePlusListener {

    @field:[Inject Named("FBHelper")]
    lateinit var facebookHelper: FacebookHelper

    @field:[Inject Named("TwitterHelper")]
    lateinit var twitterHelper: TwitterHelper

    @field:[Inject Named("GoogleHelper")]
    lateinit var googlePlusHelper: GooglePlusHelper

    @field:[Inject Named("InstagramHelper")]
    lateinit var instagramHelper: InstagramHelper


    init {
        DaggerSocialComponentProvider.builder().socialNetworkModule(SocialNetworkModule(this)).
        facebookModule(FacebookModule(config.component, this)).build().inject(this)
    }

    fun handleSocialLogin() {

        when (config.socialNetworkType) {
            SocialNetworkType.FACEBOOK -> facebookHelper
            SocialNetworkType.GOOGLE_PLUS -> googlePlusHelper
            SocialNetworkType.INSTAGRAM -> instagramHelper
            SocialNetworkType.TWITTER -> twitterHelper
        }

    }

    override fun onFacebookLoginSuccess(
            accessToken: String,
            firstName: String,
            secondName: String,
            profile: String,
            email: String
    ) {
        listener.onSocialNetworkLoginSuccess(
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


    //========================Need to implement =====================================================================
    override fun onTwitterLoginSuccess() =
            listener.onSocialNetworkLoginSuccess(Person("Sardar - onTwitterLoginSuccess"))

    override fun onTwitterLoginFail() = listener.onSocialNetworkLoginFail(
            LoginException(
                    "FBLoginFail",
                    ExceptionTypes.TWITTER_EXCEPTION
            )
    )

    override fun onInstagramLoginSuccess() =
            listener.onSocialNetworkLoginSuccess(Person("Sardar - onInstagramLoginSuccess"))

    override fun onInstagramLoginFail() = listener.onSocialNetworkLoginFail(
            LoginException(
                    "FBLoginFail",
                    ExceptionTypes.INSTAGRAM_EXCEPTION
            )
    )

    override fun onGooglePlusLoginSuccess() =
            listener.onSocialNetworkLoginSuccess(Person("Sardar - onGooglePlusLoginSuccess"))

    override fun onGooglePlusLoginFail() = listener.onSocialNetworkLoginFail(
            LoginException(
                    "FBLoginFail",
                    ExceptionTypes.GOOGLE_EXCEPTION
            )
    )


}