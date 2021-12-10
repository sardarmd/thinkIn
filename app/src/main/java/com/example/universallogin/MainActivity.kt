package com.example.universallogin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arolle.ullb.base.config.LoginConfig
import com.arolle.ullb.base.config.LoginMode
import com.arolle.ullb.base.config.SocialNetworkConfig
import com.arolle.ullb.base.config.SocialNetworkType
import com.arolle.ullb.base.core.LoginManager
import com.arolle.ullb.base.exceptions.LoginException
import com.arolle.ullb.base.listeners.OnSignInListener
import com.arolle.ullb.base.models.Person
import com.arolle.ullb.base.models.PreLoginMeta

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
class MainActivity : AppCompatActivity(), OnSignInListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoginManager.signIn(
                LoginConfig(
                        "1234", LoginMode.SOCIAL_NETWORK_LOGIN, socialConfig =
                SocialNetworkConfig(this, SocialNetworkType.FACEBOOK, socialId = "1234")
                ), this
        )
    }

    override fun onSignInProcess(preLoginMeta: PreLoginMeta?) {
    }

    override fun onSignInSuccess(person: Person) {
        Toast.makeText(this, person.name, Toast.LENGTH_LONG).show()

    }

    override fun onSignInFail(loginException: LoginException) {
    }

}
