package com.example.universallogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arolle.ullb.base.config.*
import com.arolle.ullb.base.core.LoginManager
import com.arolle.ullb.base.exceptions.LoginException
import com.arolle.ullb.base.listeners.OnPhoneNumberValidListener
import com.arolle.ullb.base.listeners.OnSignInListener
import com.arolle.ullb.base.listeners.OnSocialNetworkLoginListener
import com.arolle.ullb.base.models.Person

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
class MainActivity : AppCompatActivity(), OnSignInListener, OnPhoneNumberValidListener, OnSocialNetworkLoginListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoginManager.signIn(LoginConfig("1234", LoginMode.PHONE_NUMBER_LOGIN, phoneNumberConfig =
        PhoneNumberConfig(countryCode = "91", phoneNumber = "8970878633", this)
        ), this)

        /*  LoginManager.signIn(LoginConfig("1234", LoginMode.SOCIAL_NETWORK_LOGIN, socialConfig =
          SocialNetworkConfig(SocialNetworkType.FACEBOOK,socialId = "1234",this)
          ), this)*/
    }

    override fun onSignInSuccess(person: Person?) {
        Log.d("onSignInSuccess", "" + person)
    }

    override fun onSignInFail(loginException: LoginException) {
    }

    override fun onPhoneNumberValidationSuccess() {
    }

    override fun onPhoneNumberValidationFail() {
    }

    override fun onSecurityCodeReceive(securityCode: String) {
    }

    override fun onSecurityCodeValidationSuccess() {
    }

    override fun onSecurityCodeWaitTimeTicker(ticker: Int) {
    }

    override fun onSecurityRetryCounter(retryCounter: Int) {
    }

    override fun onSocialNetworkLoginSuccess(person: Person) {
    }

    override fun onSocialNetworkLoginFail(loginException: LoginException) {
    }


}