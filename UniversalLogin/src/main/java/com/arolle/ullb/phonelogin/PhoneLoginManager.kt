package com.arolle.ullb.phonelogin

import com.arolle.ullb.common.PhoneNumberConfig
import com.arolle.ullb.common.di.components.DaggerPhoneComponentProvider
import com.arolle.ullb.common.listeners.OnPhoneNumberValidListener
import com.arolle.ullb.common.listeners.OnSecurityCodeWaitListener

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
class PhoneLoginManager(private val pnConfig: PhoneNumberConfig, private val listener: OnPhoneNumberValidListener) {

    private var retryCount: Int = 0

    init {
        DaggerPhoneComponentProvider.builder().listener(listener).build()
    }

    fun signIn() {
        validatePhoneNumber("${pnConfig.countryCode}${pnConfig.phoneNumber}", listener)
    }

    private fun validatePhoneNumber(phoneNumber: String, listener: OnPhoneNumberValidListener) {
        //@TODO. call rest API
        listener.onPhoneNumberValidationSuccess()
        initTwoFactorAuthentication(phoneNumber, listener)
    }

    private fun initTwoFactorAuthentication(phoneNumber: String, listener: OnPhoneNumberValidListener) {
        //@TODO call rest API
        listener.onSecurityCodeReceive("1234")
    }

    fun submitSecurityCode(code: String, listener: OnSecurityCodeWaitListener) {
        //@TODO call rest API
        startTimer(listener)
        setRetryCounter(listener)

    }

    private fun startTimer(listener: OnSecurityCodeWaitListener) {
        listener.onSecurityCodeWaitTimeTicker(1)

    }

    private fun setRetryCounter(listener: OnSecurityCodeWaitListener) {
        retryCount.plus(1)
        listener.onSecurityRetryCounter(retryCount)
    }

}
