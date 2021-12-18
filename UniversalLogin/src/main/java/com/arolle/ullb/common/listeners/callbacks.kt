package com.arolle.ullb.common.listeners

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.common.exceptions.LoginException
import com.arolle.ullb.common.models.Person
import com.arolle.ullb.common.models.PreLoginMeta

interface OnClientAuthListener {
    fun onClientAuthSuccess()
    fun onClientAuthFail(message: String)
}

interface OnSocialNetworkLoginListener {
    fun onSocialNetworkLoginSuccess(person: Person)
    fun onSocialNetworkLoginFail(loginException: LoginException)
}

interface OnPhoneNumberLoginListener {
    fun onPhoneNumberLoginSuccess()
    fun onPhoneNumberLoginFail(loginException: LoginException)
}

interface OnPhoneNumberValidListener : OnSecurityCodeWaitListener {
    fun onPhoneNumberValidationSuccess()
    fun onPhoneNumberValidationFail()
    fun onSecurityCodeReceive(securityCode: String)
    fun onSecurityCodeValidationSuccess()

}

interface OnSecurityCodeWaitListener {
    fun onSecurityCodeWaitTimeTicker(ticker: Int)
    fun onSecurityRetryCounter(retryCounter: Int)
}


interface OnSignInListener {
    fun onSignInProcess(preLoginMeta: PreLoginMeta? = null)
    fun onSignInSuccess(person: Person)
    fun onSignInFail(loginException: LoginException)
}

interface OnSignOutListener {
    fun onSignOutSuccess()
    fun onSignOutFail()
}

interface SocialNetworkLoginListener {
    fun loginSuccess(data: Person)
    fun loginFail(loginException: LoginException)
}

interface SocialNetworkLogoutListener {
    fun logoutSuccess()
    fun logoutFail(loginException: LoginException)
}

