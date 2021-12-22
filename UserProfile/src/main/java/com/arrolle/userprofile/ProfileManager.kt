package com.arrolle.userprofile

import com.arrolle.userprofile.listeners.ProfileListener

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
class ProfileManager(private val listener: ProfileListener) {

    fun addPrimaryProfile(properties: Map<String, Any>) {
        val profile = ProfileHandler(ProfileType.PRIMARY_PROFILE).addOrUpdateProperties(properties)
        listener.onProfileChangeSuccess(profile, ChangeType.ADD)
    }

    fun getPrimaryProfile() {
        listener.onProfileFetchSuccess(ProfileHandler(ProfileType.PRIMARY_PROFILE).getPrimaryProfile())
    }

    fun addSecondaryProfile(properties: Map<String, Any>) {
        val profile =
            ProfileHandler(ProfileType.SECONDARY_PROFILE).addOrUpdateProperties(properties)
        listener.onProfileChangeSuccess(profile, ChangeType.ADD)
    }

    fun getSecondaryProfile(profileId: String) {
        listener.onProfileFetchSuccess(
            ProfileHandler(ProfileType.PRIMARY_PROFILE).getOtherProfile(
                profileId
            )
        )

    }

    fun updatePrimaryProfile(properties: Map<String, Any>) {
        listener.onProfileChangeSuccess(
            ProfileHandler(ProfileType.PRIMARY_PROFILE)
                .addOrUpdateProperties(properties), ChangeType.UPDATE
        )
    }

    fun removePrimaryProfile() {
    }

    fun updateSecondaryProfile(profileId: String, properties: Map<String, Any>) {
    }

    fun removeSecondaryProfile(profileId: String) {
    }

    fun reset() {
    }
}
