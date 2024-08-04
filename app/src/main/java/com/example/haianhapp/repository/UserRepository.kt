package com.example.haianhapp.repository

import com.example.haianhapp.dao.UserDao
import com.example.haianhapp.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    val allUsers: Flow<List<User>> = userDao.getAllUsers()

    suspend fun insert(user : User){
        userDao.insert(user)
    }

    suspend fun update(user : User){
        userDao.update(user)
    }

}