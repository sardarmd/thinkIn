package com.arolle.ullb.sociallogin.fb

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.arolle.ullb.sociallogin.listeners.FacebookListener
import com.facebook.*
import com.facebook.login.LoginManager.getInstance
import com.facebook.login.LoginResult


/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
internal class FacebookHelper(
    private val fbListener: FacebookListener,
    private val component: Any
) {
    private var mCallBackManager: CallbackManager = CallbackManager.Factory.create()

    private val mCallBack: FacebookCallback<LoginResult?> =
        object : FacebookCallback<LoginResult?> {
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

    init {
        getInstance().registerCallback(mCallBackManager, mCallBack)
        val context: Context? =
            if (component is Fragment) component.context else component as Activity
        getInstance().retrieveLoginStatus(context, object : LoginStatusCallback {
            override fun onCompleted(accessToken: AccessToken) {
                val profile = Profile.getCurrentProfile()
                fbListener.onFacebookLoginSuccess(
                    accessToken = accessToken.token,
                    firstName = profile?.firstName.toString(),
                    secondName = profile?.lastName.toString(),
                    profile = profile?.getProfilePictureUri(100, 100).toString(),
                )

            }

            override fun onFailure() = login()

            override fun onError(exception: Exception) {
                exception.message?.let { fbListener.onFacebookLoginFail(it) }
            }
        })

    }

    private fun login() {

        if (component is Fragment) {
            getInstance()
                .logInWithReadPermissions(
                    component,
                    mCallBackManager,
                    listOf("public_profile", "email")
                )
        }; else if (component is Activity) {
            getInstance()
                .logInWithReadPermissions(
                    component,
                    listOf("public_profile", "email")
                )
        }
    }

    private fun logout() {
        getInstance().logOut()
    }
}
