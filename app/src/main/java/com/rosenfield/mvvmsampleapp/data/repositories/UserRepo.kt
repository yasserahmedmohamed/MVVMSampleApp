package com.rosenfield.mvvmsampleapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rosenfield.mvvmsampleapp.data.network.ServiceApis
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {

    fun userlogin(email:String , password:String):LiveData<String>{
        val  loginresponce = MutableLiveData<String>()
        ServiceApis().UserLogin(email,password).enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loginresponce.value = t.message
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    loginresponce.value = response.body()?.string()
                }
                else{
                    loginresponce.value = response.errorBody()?.string()
                }
            }
        })
        return loginresponce
    }
}