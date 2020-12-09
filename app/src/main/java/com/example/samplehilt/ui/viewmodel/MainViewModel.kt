package com.example.samplehilt.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplehilt.data.model.User
import com.example.samplehilt.data.repository.MainRepository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : ViewModel(){

    private val _users = MutableLiveData<List<User>>()
    val users : MutableLiveData<List<User>>
        get() = _users

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : MutableLiveData<String>
        get() = _errorMessage

    init {
        fetchUsers()
    }

    private fun fetchUsers() = viewModelScope.launch{
        try{
            _users.value = mainRepository.getUsers().body()
        }catch (e : Exception){
            _errorMessage.value = e.message
        }
    }

}