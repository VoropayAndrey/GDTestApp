package com.hardway.gdtest.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hardway.gdtest.domain.usecases.ComplicatedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class ComplicatedViewModel
    @Inject constructor(val complicatedUseCase: ComplicatedUseCase): ViewModel() {

    val complicatedAlgorithmResult = MutableLiveData<Boolean>()

    fun runComplicatedAlgorithm() {
        viewModelScope.launch {
            var result = complicatedUseCase.invoke()
            withContext(Dispatchers.Main) {
                complicatedAlgorithmResult.value = result
            }
        }
    }
}