package com.arrolle.userprofile

import com.arrolle.userprofile.model.Profile

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
internal class ProfileHandler( private val type: ProfileType) {

    fun addOrUpdateProperties(properties: Map<String, Any>): Profile {
        return Profile("", type)
    }

    fun addOrUpdateProperty(profileId: String, key: String, value:Any) {
    }

    fun getPrimaryProfile(): Profile {
        return Profile("", ProfileType.PRIMARY_PROFILE)
    }

    fun getOtherProfile(profileId: String): Profile {
        return Profile(profileId, ProfileType.SECONDARY_PROFILE)
    }

    fun getPrimaryProfileProperty(propertyKey: String): Any {
        return getPrimaryProfile().properties!!.get(propertyKey)!!
    }

    fun getOtherProfileProperty(profileId: String, propertyKey: String): Any {
        return getOtherProfile(profileId).properties!!.get(propertyKey)!!
    }

    fun removeProperty(profileId: String, propertyKey: String) {
    }

    fun removeProperties(profileId: String, propertyKeyArray: Array<String>) {
    }
}