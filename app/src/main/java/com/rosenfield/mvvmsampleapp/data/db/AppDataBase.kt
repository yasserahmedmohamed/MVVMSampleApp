package com.rosenfield.mvvmsampleapp.data.db

import androidx.room.Database
import com.rosenfield.mvvmsampleapp.data.db.entities.User

@Database(entities = [User::class],version = 1)
abstract class AppDataBase {
    abstract fun getuserDao() : UserDao

    companion object{
        @Volatile
        private var instance:AppDataBase? = null

    }
}