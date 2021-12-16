package com.arolle.ullb.common

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */

import com.arolle.ullb.common.exceptions.ExceptionTypes
import com.arolle.ullb.common.exceptions.LoginException
import com.arolle.ullb.common.listeners.OnClientAuthListener
import com.arolle.ullb.common.listeners.OnSecurityCodeWaitListener
import com.arolle.ullb.common.listeners.OnSignInListener
import com.arolle.ullb.common.listeners.OnSocialNetworkLoginListener
import com.arolle.ullb.common.models.Person
import com.arolle.ullb.phonelogin.PhoneLoginManager
import com.arolle.ullb.sociallogin.SocialNetworkManager


class LoginManager(private val loginConfig: LoginConfig, private val signInListener: OnSignInListener) : OnClientAuthListener, OnSocialNetworkLoginListener {
    private var mode: LoginMode = loginConfig.mode

    fun signIn() {
        validateApplication()
    }

    fun validateSecurityCode(code: String, waitListener: OnSecurityCodeWaitListener) {
        PhoneLoginManager.submitSecurityCode(code, waitListener)
    }

    private fun validateApplication() {
        //@todo- we need to call the backend api and on success api we have to call the API
        if (mode == LoginMode.SOCIAL_NETWORK_LOGIN) proceedToSocialLogin() else proceedToPhoneLogin()
    }

    private fun proceedToSocialLogin() {
        loginConfig.socialConfig?.let { SocialNetworkManager(loginConfig.socialConfig!!, this).handleSocialLogin() }
    }

    private fun proceedToPhoneLogin() {
        loginConfig.phoneNumberConfig?.let {
            PhoneLoginManager.handlePhoneNumberLogin(
                    it,
                    loginConfig.phoneNumberConfig!!.phoneNumberValidListener
            )
        }

    }

    override fun onClientAuthSuccess() =
            if (mode == LoginMode.PHONE_NUMBER_LOGIN) proceedToPhoneLogin() else proceedToSocialLogin()

    override fun onClientAuthFail(message: String) =
            signInListener.onSignInFail(LoginException(message, ExceptionTypes.INVALID_APPLICATION))

    override fun onSocialNetworkLoginSuccess(person: Person) {
        signInListener.onSignInSuccess(person)
    }

    override fun onSocialNetworkLoginFail(loginException: LoginException) {
    }


    fun signOut() {

    }

}