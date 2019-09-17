package com.rosenfield.mvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData
import com.rosenfield.mvvmsampleapp.enums.StatusConditions

interface AuthListener {

    fun Status(status:StatusConditions,message:String)
    fun OnSuccess(LoginResponce:LiveData<String>)

}
