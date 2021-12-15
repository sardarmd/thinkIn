package com.arolle.ullb.sociallogin.di.components

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.sociallogin.core.SocialNetworkManager
import com.arolle.ullb.sociallogin.di.modules.FacebookModule
import com.arolle.ullb.sociallogin.di.modules.SocialNetworkModule
import dagger.Component

@Component(modules = [SocialNetworkModule::class,FacebookModule::class])
interface SocialComponentProvider {
    fun inject(socialNetworkManager: SocialNetworkManager)

}