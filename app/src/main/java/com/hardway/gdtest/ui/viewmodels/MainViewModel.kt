package com.hardway.gdtest.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hardway.gdtest.domain.entities.ContactEntity
import com.hardway.gdtest.domain.usecases.FirstInitContactsUseCase
import com.hardway.gdtest.domain.usecases.ResetDatabaseUseCase
import com.hardway.gdtest.repositories.LocalRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    val localRepositoryInterface: LocalRepositoryInterface,
    val firstInitContactsUseCase: FirstInitContactsUseCase,
    val resetDatabaseUseCase: ResetDatabaseUseCase
): ViewModel() {

    val contactsLiveData = MutableLiveData<List<ContactEntity>>()

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                firstInitContactsUseCase.invoke()
                var contacts = localRepositoryInterface.getAll()
                withContext(Dispatchers.Main) {
                    contactsLiveData.value = contacts
                }
            }
        }

    }

    fun reloadAll() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                resetDatabaseUseCase.invoke()
                var contacts = localRepositoryInterface.getAll()
                withContext(Dispatchers.Main) {
                    contactsLiveData.value = contacts
                }
            }
        }
    }
}