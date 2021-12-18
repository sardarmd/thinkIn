package com.arolle.ullb.sociallogin.fb

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.arolle.ullb.common.exceptions.ExceptionTypes
import com.arolle.ullb.common.exceptions.LoginException
import com.arolle.ullb.common.listeners.SocialNetworkLoginListener
import com.arolle.ullb.common.models.Person
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
 */
class FacebookImpl(private val component: Any, private val listener: SocialNetworkLoginListener) {

    private val fbLoginManager: LoginManager get() = getInstance()

    init {
        fbLoginManager.registerCallback(getFacebookCallBackManager(), getFacebookCallbackListener(listener))
        getLoginState()
    }

    private fun getLoginState() {

        val context: Context? = if (component is Fragment) component.context else component as Activity

        fbLoginManager.retrieveLoginStatus(context, object : LoginStatusCallback {
            override fun onCompleted(accessToken: AccessToken) {
                val profile = Profile.getCurrentProfile()
                if (profile == null) login() else
                    listener.loginSuccess((Person(name = profile?.firstName.toString().plus(profile?.lastName.toString()), profilePic
                    = profile?.getProfilePictureUri(100, 100).toString(), email = profile?.getProfilePictureUri(100, 100).toString(), uniqueId = accessToken.token)))


            }

            override fun onFailure() = login()

            override fun onError(exception: Exception) {
                listener.loginFail(LoginException("Facebook login fail", ExceptionTypes.FACEBOOK_EXCEPTION))
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
