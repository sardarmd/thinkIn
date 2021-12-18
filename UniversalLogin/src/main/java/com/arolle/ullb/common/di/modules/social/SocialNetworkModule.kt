package com.arolle.ullb.common.di.modules.social

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.common.di.scopes.GlobalScope
import com.arolle.ullb.common.listeners.SocialNetworkLoginListener
import com.arolle.ullb.sociallogin.fb.FacebookImpl
import com.arolle.ullb.sociallogin.googleplus.GooglePlusImpl
import com.arolle.ullb.sociallogin.instagram.InstagramImpl
import com.arolle.ullb.sociallogin.twitter.TwitterImpl
import dagger.Module
import dagger.Provides

@Module
object SocialNetworkModule {

    @Provides
    @GlobalScope
    fun provideFacebookHelper(uiComponent: Any, listener: SocialNetworkLoginListener): FacebookImpl = FacebookImpl(uiComponent, listener)

    @Provides
    @GlobalScope
    fun provideTwitterHelper(listener: SocialNetworkLoginListener): TwitterImpl = TwitterImpl(listener)

    @Provides
    @GlobalScope
    fun provideGoogle(listener: SocialNetworkLoginListener): GooglePlusImpl = GooglePlusImpl(listener)

    @Provides
    @GlobalScope
    fun provideInstagramHelper(listener: SocialNetworkLoginListener): InstagramImpl = InstagramImpl(listener)
}