package com.arolle.ullb.base.exceptions

class LoginException( message:String ="LoginException",exceptionType:ExceptionTypes) : IllegalArgumentException(message) {

}

enum class ExceptionTypes{
    INVALID_PHONE_NUMBER, INVALID_SOCIAL_ID, INVALID_APPLICATION, FACEBOOK_EXCEPTION,TWITTER_EXCEPTION,
    INSTAGRAM_EXCEPTION,GOOGLE_EXCEPTION
}