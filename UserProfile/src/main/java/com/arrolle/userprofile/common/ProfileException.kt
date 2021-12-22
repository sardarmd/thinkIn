package com.arrolle.userprofile.common
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
class ProfileException( message:String ="LoginException",exceptionType:ExceptionTypes) : IllegalArgumentException(message)

enum class ExceptionTypes{
    INVALID_PROFILE_ID, UPDATE_FAILED
}