package com.arolle.ullb.sociallogin.listeners

import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
internal fun getFacebookCallBackManager():CallbackManager= CallbackManager.Factory.create()

internal fun getFacebookCallbackListener(fbListener: FacebookListener): FacebookCallback<LoginResult?> {

    return object : FacebookCallback<LoginResult?> {
        override fun onCancel() = fbListener.onFacebookLoginFail("Cancelled")

        override fun onError(e: FacebookException) {
            fbListener.onFacebookLoginFail(e.message.toString())
        }

        override fun onSuccess(result: LoginResult?) {

            result?.accessToken?.token?.let {
                fbListener.onFacebookLoginSuccess(
                        it,
                        result.accessToken.userId
                )
            }
        }
    }
}

