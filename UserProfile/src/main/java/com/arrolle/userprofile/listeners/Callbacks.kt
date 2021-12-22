package com.arrolle.userprofile.listeners
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arrolle.userprofile.ChangeType
import com.arrolle.userprofile.common.ProfileException
import com.arrolle.userprofile.model.Profile

interface ProfileListener {
    fun onProfileFetchSuccess(profile:Profile)
    fun onProfileChangeSuccess(profile: Profile, changeType: ChangeType)
    fun onProfileChangeFail(exception: ProfileException)
}