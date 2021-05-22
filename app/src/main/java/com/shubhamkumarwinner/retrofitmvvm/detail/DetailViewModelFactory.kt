package com.shubhamkumarwinner.retrofitmvvm.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubhamkumarwinner.retrofitmvvm.network.User

class DetailViewModelFactory(private val user: User): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(user) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}