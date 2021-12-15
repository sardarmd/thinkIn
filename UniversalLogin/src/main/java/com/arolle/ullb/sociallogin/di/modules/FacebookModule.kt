package com.arolle.ullb.sociallogin.di.modules
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.sociallogin.fb.FacebookHelper
import com.arolle.ullb.sociallogin.listeners.FacebookListener
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class FacebookModule(private val component: Any, private val listener: FacebookListener) {

    @Provides
    @Named("FBHelper")
    fun provideFacebookHelper(): FacebookHelper = FacebookHelper(component, listener)

}