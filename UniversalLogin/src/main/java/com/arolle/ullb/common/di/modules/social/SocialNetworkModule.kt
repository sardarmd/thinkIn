package com.arolle.ullb.common.di.modules.social
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.common.listeners.GooglePlusListener
import com.arolle.ullb.common.listeners.InstagramListener
import com.arolle.ullb.common.listeners.TwitterListener
import com.arolle.ullb.sociallogin.googleplus.GooglePlusHelper
import com.arolle.ullb.sociallogin.instagram.InstagramHelper
import com.arolle.ullb.sociallogin.twitter.TwitterHelper
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class SocialNetworkModule(private val listener: Any) {

    private val twitterListener get() = listener as TwitterListener
    private val googlePlusListener get() = listener as GooglePlusListener
    private val instagramListener get() = listener as InstagramListener


    @Provides
    @Named("TwitterHelper")
    fun provideTwitterHelper(): TwitterHelper = TwitterHelper(twitterListener)

    @Provides
    @Named("GoogleHelper")
    fun provideGoogle(): GooglePlusHelper = GooglePlusHelper(googlePlusListener)

    @Provides
    @Named("InstagramHelper")
    fun provideInstagramHelper(): InstagramHelper = InstagramHelper(instagramListener)
}