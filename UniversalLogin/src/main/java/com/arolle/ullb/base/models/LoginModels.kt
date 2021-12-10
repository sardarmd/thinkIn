package com.arolle.ullb.base.models
/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
data class Person(var name:String ="", var email:String ="",var profilePic:String ="",   var uniqueId:String ="")
data class PreLoginMeta(var OTP:String ="", var timer:Int =0,var retryCount:Int =0)
