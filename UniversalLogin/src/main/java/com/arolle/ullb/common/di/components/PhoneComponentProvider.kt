package com.arolle.ullb.common.di.components

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import com.arolle.ullb.common.di.modules.phone.PhoneModule
import com.arolle.ullb.common.listeners.OnPhoneNumberValidListener
import com.arolle.ullb.phonelogin.PhoneLoginManager
import dagger.BindsInstance
import dagger.Component

@Component(modules = [PhoneModule::class])
interface PhoneComponentProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun listener(listener: OnPhoneNumberValidListener): Builder
        fun build(): PhoneComponentProvider
    }

    fun inject(phoneManager: PhoneLoginManager)
}