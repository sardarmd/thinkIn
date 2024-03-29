package com.arolle.kiddo

/**
 * Copyright (c) 2021 Arolle solutions All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arolle.ullb.common.LoginConfig
import com.arolle.ullb.common.LoginMode
import com.arolle.ullb.common.SocialNetworkConfig
import com.arolle.ullb.common.SocialNetworkType
import com.arolle.ullb.common.LoginManager
import com.arolle.ullb.common.exceptions.LoginException
import com.arolle.ullb.common.listeners.OnSignInListener
import com.arolle.ullb.common.models.Person
import com.arolle.ullb.common.models.PreLoginMeta
import com.arrolle.userprofile.ChangeType
import com.arrolle.userprofile.ProfileManager
import com.arrolle.userprofile.common.ProfileException
import com.arrolle.userprofile.listeners.ProfileListener
import com.arrolle.userprofile.model.Profile

class MainActivity : AppCompatActivity(), OnSignInListener, ProfileListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginManager = LoginManager(
            LoginConfig(
                "1234", LoginMode.SOCIAL_NETWORK_LOGIN,
                socialConfig = SocialNetworkConfig(
                    this, SocialNetworkType.FACEBOOK,
                    socialId = "1234"
                )
            ), this
        )
        loginManager.signIn()
    }

    override fun onSignInProcess(preLoginMeta: PreLoginMeta?) {
    }

    override fun onSignInSuccess(person: Person) {
        val props: MutableMap<String, Any> = mutableMapOf()
        props.put("id", person.uniqueId)
        ProfileManager(this).addPrimaryProfile(props)
    }

    override fun onSignInFail(loginException: LoginException) {}

    override fun onProfileFetchSuccess(profile: Profile) {
        Toast.makeText(this, "Profile fetched", Toast.LENGTH_LONG).show()
    }

    override fun onProfileChangeSuccess(profile: Profile, changeType: ChangeType) {
        Toast.makeText(this, "Profile Changed", Toast.LENGTH_LONG).show()
    }

    override fun onProfileChangeFail(exception: ProfileException) {
    }

}
