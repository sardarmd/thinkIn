package com.arolle.ullb.sociallogin.fb

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.arolle.ullb.sociallogin.listeners.FacebookListener
import com.arolle.ullb.sociallogin.listeners.getFacebookCallBackManager
import com.arolle.ullb.sociallogin.listeners.getFacebookCallbackListener
import com.facebook.AccessToken
import com.facebook.LoginStatusCallback
import com.facebook.Profile
import com.facebook.login.LoginManager
import com.facebook.login.LoginManager.getInstance

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
internal class FacebookHelper(private val component: Any, private val fbListener: FacebookListener) {

    private val fbLoginManager: LoginManager = getInstance()

    init {
        fbLoginManager.registerCallback(getFacebookCallBackManager(), getFacebookCallbackListener(fbListener))
        getLoginState()
    }

    private fun getLoginState() {

        val context: Context? = if (component is Fragment) component.context else component as Activity

        fbLoginManager.retrieveLoginStatus(context, object : LoginStatusCallback {
            override fun onCompleted(accessToken: AccessToken) {
                val profile = Profile.getCurrentProfile()
                if (profile == null) login() else
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
        val permissions = listOf("public_profile", "email")
        if (component is Fragment) {
            fbLoginManager.logInWithReadPermissions(component, getFacebookCallBackManager(), permissions)
        }; else fbLoginManager.logInWithReadPermissions(component as Activity, permissions)
    }

    private fun logOut() {
        fbLoginManager.logOut()
    }
}
