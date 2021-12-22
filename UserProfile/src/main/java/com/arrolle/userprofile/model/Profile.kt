package com.arrolle.userprofile.model
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arrolle.userprofile.ProfileType

data class Profile(
    val id: String, private val type: ProfileType,
    val properties: Map<String, Any>?=null)
