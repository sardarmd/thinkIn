package com.arolle.ullb.sociallogin

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.common.SocialNetworkConfig
import com.arolle.ullb.common.SocialNetworkType
import com.arolle.ullb.common.di.components.DaggerSocialComponentProvider
import com.arolle.ullb.common.exceptions.LoginException
import com.arolle.ullb.common.listeners.OnSocialNetworkLoginListener
import com.arolle.ullb.common.listeners.SocialNetworkLoginListener
import com.arolle.ullb.common.listeners.SocialNetworkLogoutListener
import com.arolle.ullb.common.models.Person
import com.arolle.ullb.sociallogin.fb.FacebookImpl
import com.arolle.ullb.sociallogin.googleplus.GooglePlusImpl
import com.arolle.ullb.sociallogin.instagram.InstagramImpl
import com.arolle.ullb.sociallogin.twitter.TwitterImpl
import javax.inject.Inject

class SocialNetworkManager(private val config: SocialNetworkConfig, private val loginListener: OnSocialNetworkLoginListener) :
        SocialNetworkLoginListener, SocialNetworkLogoutListener {

    @field:Inject
    lateinit var facebookImpl: FacebookImpl

    @field:Inject
    lateinit var twitterImpl: TwitterImpl

    @field:Inject
    lateinit var googlePlusImpl: GooglePlusImpl

    @field:Inject
    lateinit var instagramImpl: InstagramImpl

    init {
        DaggerSocialComponentProvider.builder().loginListener(this)
                .logoutListener(this).uiComponent(config.component).build()
                .inject(this)
    }

    fun singIn() {
        when (config.socialNetworkType) {
            SocialNetworkType.FACEBOOK -> facebookImpl
            SocialNetworkType.GOOGLE_PLUS -> googlePlusImpl
            SocialNetworkType.INSTAGRAM -> instagramImpl
            SocialNetworkType.TWITTER -> twitterImpl
        }
    }

    fun signOut() {

    }


    override fun loginSuccess(data: Person) {
        loginListener.onSocialNetworkLoginSuccess(data)
    }

    override fun loginFail(loginException: LoginException) {
        loginListener.onSocialNetworkLoginFail(loginException)
    }

    override fun logoutSuccess() {
    }

    override fun logoutFail(loginException: LoginException) {
    }


}