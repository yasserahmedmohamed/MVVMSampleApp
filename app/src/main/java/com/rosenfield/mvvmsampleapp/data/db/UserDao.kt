package com.rosenfield.mvvmsampleapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rosenfield.mvvmsampleapp.data.db.entities.CURRENT_USER_ID
import com.rosenfield.mvvmsampleapp.data.db.entities.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user:User):Long

    @Query("SELECT * FROM User where uid = $CURRENT_USER_ID")
    fun getuser() : LiveData<User>
}