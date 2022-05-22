package com.hardway.gdtest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hardway.gdtest.di.modules.EventBusModule
import com.hardway.gdtest.domain.LoginEventBus
import com.hardway.gdtest.domain.entities.ContactEntity
import com.hardway.gdtest.domain.entities.EventEntity
import com.hardway.gdtest.domain.usecases.FirstInitContactsUseCase
import com.hardway.gdtest.domain.usecases.ResetDatabaseUseCase
import com.hardway.gdtest.repositories.LocalRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel: ViewModel {
    val contactsLiveData: MutableLiveData<EventEntity> = MutableLiveData<EventEntity>()
    private val loginEventBus: LoginEventBus

    @Inject constructor(loginEventBus: LoginEventBus) : super() {
        this.loginEventBus = loginEventBus
        viewModelScope.launch {
            loginEventBus.listen().collect { value ->
                contactsLiveData.value = value
            }
        }
    }

}