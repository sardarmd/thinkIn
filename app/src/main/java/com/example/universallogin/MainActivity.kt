package com.example.universallogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arolle.ullb.base.config.LoginConfig
import com.arolle.ullb.base.config.LoginMode
import com.arolle.ullb.base.config.SocialNetworkConfig
import com.arolle.ullb.base.config.SocialNetworkType
import com.arolle.ullb.base.core.LoginManager
import com.arolle.ullb.base.exceptions.LoginException
import com.arolle.ullb.base.listeners.OnSignInListener
import com.arolle.ullb.base.models.Person
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
class MainActivity : AppCompatActivity(),OnSignInListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoginManager.signIn(LoginConfig("1234",LoginMode.SOCIAL_NETWORK_LOGIN,
            SocialNetworkConfig(SocialNetworkType.FACEBOOK)
        ),this)
    }

    override fun onSignInSuccess(person: Person?) {
        Log.d("onSignInSuccess",""+person)
    }

    override fun onSignInFail(loginException: LoginException) {
    }


}