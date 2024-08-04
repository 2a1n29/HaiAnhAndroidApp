package com.example.haianhapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.haianhapp.model.Contact
import com.example.haianhapp.model.User
import com.example.haianhapp.repository.UserRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UserViewModel(private val repository: UserRepository): ViewModel() {

    val allUsers: LiveData<List<User>> = repository.allUsers.asLiveData()

    fun addUser(name:String, greeting: String){
        viewModelScope.launch {
            val user = User(0,name,greeting)
            repository.insert(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch {
            repository.update(user)
        }
    }

    fun deleteContact(user: User){
        viewModelScope.launch {
            repository.delete(user)
        }
    }
}

class UserViewModelFactory(private val repository: UserRepository): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}