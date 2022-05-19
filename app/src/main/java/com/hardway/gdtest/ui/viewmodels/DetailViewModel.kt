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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject constructor(
    val localRepositoryInterface: LocalRepositoryInterface,
): ViewModel() {

    val fetchedContact: MutableLiveData<ContactEntity> = MutableLiveData()

    fun fetchUserById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                var contact = localRepositoryInterface.getById(id)
                delay(500)
                withContext(Dispatchers.Main) {
                    fetchedContact.value = contact
                }
            }
        }
    }
}