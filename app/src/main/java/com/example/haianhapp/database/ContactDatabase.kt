package com.example.haianhapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.haianhapp.dao.ContactDao
import com.example.haianhapp.dao.UserDao
import com.example.haianhapp.model.Contact
import com.example.haianhapp.model.User

@Database(entities = [Contact::class, User::class], version = 1, exportSchema = false)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun userDao() : UserDao
}