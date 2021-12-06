package com.arolle.ullb.sociallogin.fb

import com.arolle.ullb.sociallogin.listeners.FacebookListener

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
internal class FacebookHelper(private val fbListener: FacebookListener) {
    init {
        fbListener.onFacebookLoginSuccess()
    }
}
