package com.arolle.ullb.base.core

import com.arolle.ullb.base.config.LoginConfig
import com.arolle.ullb.base.config.LoginMode
import com.arolle.ullb.base.exceptions.ExceptionTypes
import com.arolle.ullb.base.exceptions.LoginException
import com.arolle.ullb.base.listeners.OnClientAuthListener
import com.arolle.ullb.base.listeners.OnPhoneNumberLoginListener
import com.arolle.ullb.base.listeners.OnSignInListener
import com.arolle.ullb.base.listeners.OnSocialNetworkLoginListener
import com.arolle.ullb.base.models.Person
import com.arolle.ullb.sociallogin.core.SocialNetworkManager

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */


object LoginManager : OnClientAuthListener, OnSocialNetworkLoginListener,
    OnPhoneNumberLoginListener {
    private lateinit var mode: LoginMode
    private lateinit var mSignInListener: OnSignInListener
    private lateinit var mLoginConfig: LoginConfig
    fun signIn(loginConfig: LoginConfig, signInListener: OnSignInListener) {
        mode = loginConfig.mode
        mLoginConfig = loginConfig
        mSignInListener = signInListener
        validateApplication()
    }

    fun signOut() {

    }

    private fun validateApplication() {
        proceedToSocialLogin()
    }

    private fun proceedToSocialLogin() {
        mLoginConfig.socialConfig?.let { SocialNetworkManager.handleSocialLogin(it, this) }
    }

    private fun proceedToPhoneLogin() {

    }

    override fun onClientAuthSuccess() =
        if (mode == LoginMode.PHONE_NUMBER_LOGIN) proceedToPhoneLogin() else proceedToSocialLogin()

    override fun onClientAuthFail(message: String) =
        mSignInListener.onSignInFail(LoginException(message, ExceptionTypes.INVALID_APPLICATION))

    override fun onSocialNetworkLoginSuccess(person: Person) =
        mSignInListener.onSignInSuccess(person)

    override fun onSocialNetworkLoginFail(loginException: LoginException) =
        mSignInListener.onSignInFail(loginException)

    override fun onPhoneNumberLoginSuccess() = mSignInListener.onSignInSuccess()

    override fun onPhoneNumberLoginFail(loginException: LoginException) =
        mSignInListener.onSignInFail(loginException)
}