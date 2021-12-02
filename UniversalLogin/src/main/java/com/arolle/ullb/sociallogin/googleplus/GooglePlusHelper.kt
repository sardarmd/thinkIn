package com.arolle.ullb.sociallogin.googleplus

import com.arolle.ullb.sociallogin.listeners.GooglePlusListener
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
class GooglePlusHelper(private  val googlePlusListener: GooglePlusListener) {

    init {
        googlePlusListener.onGooglePlusLoginSuccess()
    }
}