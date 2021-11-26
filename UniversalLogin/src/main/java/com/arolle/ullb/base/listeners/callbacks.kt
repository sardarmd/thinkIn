package com.arolle.ullb.base.listeners

import com.arolle.ullb.base.exceptions.LoginException
import com.arolle.ullb.base.models.Person

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
 interface OnClientAuthListener {
    fun onClientAuthSuccess()
    fun onClientAuthFail(message:String)
}

interface OnSocialNetworkLoginListener {
    fun onSocialNetworkLoginSuccess(person: Person)
    fun onSocialNetworkLoginFail(loginException: LoginException)
}

interface OnPhoneNumberLoginListener {
    fun onPhoneNumberLoginSuccess()
    fun onPhoneNumberLoginFail(loginException: LoginException)
}


 interface OnSignInListener {
    fun onSignInSuccess(person: Person?=null)
    fun onSignInFail(loginException: LoginException)
}
 interface OnSignOutListener {
    fun onSignOutSuccess()
    fun onSignOutFail()
}