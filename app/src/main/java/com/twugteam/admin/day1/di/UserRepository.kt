package com.twugteam.admin.day1.di

import android.util.Log

interface UserRepository{
    fun saveUser()
}


class SQLRepository:UserRepository{
    override fun saveUser() {
        Log.d("REPO", "User Saved to SQL ")
    }

}

class FirebaseRepository:UserRepository{
    override fun saveUser() {
        Log.d("REPO", "User Saved to Firebase ")
    }
}

class MongoDBRepository:UserRepository{
    override fun saveUser() {
        Log.d("REPO", "User Saved to MongoDB ")
    }

}

