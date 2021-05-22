package com.shubhamkumarwinner.retrofitmvvm.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubhamkumarwinner.retrofitmvvm.network.User

class DetailViewModelFactory(private val user: User, private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(user, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}