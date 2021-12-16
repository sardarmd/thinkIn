package com.arolle.ullb.common.di.components.social

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.sociallogin.SocialNetworkManager
import com.arolle.ullb.common.di.modules.social.FacebookModule
import com.arolle.ullb.common.di.modules.social.SocialNetworkModule
import dagger.Component

@Component(modules = [SocialNetworkModule::class, FacebookModule::class])
interface SocialComponentProvider {
    fun inject(socialNetworkManager: SocialNetworkManager)

}