package com.arolle.ullb.common.di.components

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.common.di.modules.social.SocialNetworkModule
import com.arolle.ullb.common.di.scopes.GlobalScope
import com.arolle.ullb.common.listeners.SocialNetworkLoginListener
import com.arolle.ullb.common.listeners.SocialNetworkLogoutListener
import com.arolle.ullb.sociallogin.SocialNetworkManager
import dagger.BindsInstance
import dagger.Component

@GlobalScope
@Component(modules = [SocialNetworkModule::class])
interface SocialComponentProvider {
    fun inject(socialNetworkManager: SocialNetworkManager)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun loginListener(listener: SocialNetworkLoginListener): Builder

        @BindsInstance
        fun logoutListener(listener: SocialNetworkLogoutListener): Builder

        @BindsInstance
        fun uiComponent(component: Any): Builder

        fun build(): SocialComponentProvider
    }

}