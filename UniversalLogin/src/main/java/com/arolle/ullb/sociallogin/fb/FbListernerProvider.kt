package com.arolle.ullb.sociallogin.listeners

import com.arolle.ullb.common.exceptions.ExceptionTypes
import com.arolle.ullb.common.exceptions.LoginException
import com.arolle.ullb.common.listeners.SocialNetworkLoginListener
import com.arolle.ullb.common.models.Person
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
internal fun getFacebookCallBackManager(): CallbackManager = CallbackManager.Factory.create()

internal fun getFacebookCallbackListener(listener: SocialNetworkLoginListener): FacebookCallback<LoginResult?> {

    return object : FacebookCallback<LoginResult?> {
        override fun onCancel() = listener.loginFail(LoginException("Facebook login fail", ExceptionTypes.FACEBOOK_EXCEPTION))

        override fun onError(e: FacebookException) {
            listener.loginFail(LoginException("Facebook login fail", ExceptionTypes.FACEBOOK_EXCEPTION))
        }

        override fun onSuccess(result: LoginResult?) {
            result?.accessToken?.token?.let {
                listener.loginSuccess(
                        Person(uniqueId = result.accessToken.userId)
                )
            }
        }
    }
}

