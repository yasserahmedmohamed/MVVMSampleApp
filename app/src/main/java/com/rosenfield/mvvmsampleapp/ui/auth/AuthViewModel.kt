package com.rosenfield.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.rosenfield.mvvmsampleapp.data.repositories.UserRepo
import com.rosenfield.mvvmsampleapp.enums.StatusConditions

class AuthViewModel : ViewModel() {
    var email:String?=null
    var password:String?=null

    var authListener:AuthListener?  = null
    fun OnLoginBtnClick(View:View)
    {

        if (email.isNullOrEmpty())
        {
            authListener?.Status(StatusConditions.fail,"Please enter email")
            return
        }
        if (password.isNullOrEmpty())
        {
            authListener?.Status(StatusConditions.fail,"Please enter password")
            return
        }

        authListener?.Status(StatusConditions.loading,"")

       val loginResponce = UserRepo().userlogin(email!!,password!!)
        authListener?.OnSuccess(loginResponce)
    }
}