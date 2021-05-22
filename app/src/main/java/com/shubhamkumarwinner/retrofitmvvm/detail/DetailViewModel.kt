package com.shubhamkumarwinner.retrofitmvvm.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shubhamkumarwinner.retrofitmvvm.network.User

class DetailViewModel(user: User) : ViewModel() {
    private val _selectedUser = MutableLiveData<User>()
    val selectedUser: LiveData<User>
        get() = _selectedUser

    init {
        _selectedUser.value = user
    }
}