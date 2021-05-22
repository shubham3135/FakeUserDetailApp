package com.shubhamkumarwinner.retrofitmvvm.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhamkumarwinner.retrofitmvvm.network.User
import com.shubhamkumarwinner.retrofitmvvm.network.UserApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationViewModel @Inject constructor(
    private val api: UserApiService
): ViewModel() {
    private val _status = MutableLiveData<String>()
    // The external immutable LiveData for the request status String
    val status: LiveData<String>
        get() = _status

    private val _details = MutableLiveData<List<User>>()
    // The external immutable LiveData for the request status String
    val details: LiveData<List<User>>
        get() = _details

    private val _navigateToSelectedUser = MutableLiveData<User?>()
    val navigateToSelectedUser: LiveData<User?>
        get() = _navigateToSelectedUser

    init {
        getUserDetail()
    }

    private fun getUserDetail() {
        viewModelScope.launch {
            try {
                _details.value = api.getUsers()
                _status.value = "Number of user is ${_details.value!!.size}"
            }catch (e: Exception){
                _status.value = "Failure by: ${e.message}"
                _details.value = ArrayList()
            }
        }
    }

    fun displayUserDetails(user: User){
        _navigateToSelectedUser.value = user
    }

    fun displayUserDetailsCompleted(){
        _navigateToSelectedUser.value = null
    }
}