package com.arolle.ullb.base.exceptions

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 * This is main class which will be exposed to clients
 */
class LoginException( message:String ="LoginException",exceptionType:ExceptionTypes) : IllegalArgumentException(message)

enum class ExceptionTypes{
    INVALID_PHONE_NUMBER, INVALID_SOCIAL_ID, INVALID_APPLICATION, FACEBOOK_EXCEPTION,TWITTER_EXCEPTION,
    INSTAGRAM_EXCEPTION,GOOGLE_EXCEPTION
}