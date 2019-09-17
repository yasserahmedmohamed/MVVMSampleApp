package com.rosenfield.mvvmsampleapp.data.network


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ServiceApis {
    @FormUrlEncoded
    @POST("login")
    fun UserLogin(
        @Field("enail") email:String,
        @Field("password") password:String
    ) : Call<ResponseBody>

    companion object{
        operator fun invoke():ServiceApis{
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ServiceApis::class.java)

        }
    }
}