package com.slutsenko.newsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel() {

//    fun <T> launchRequest(
//        liveData: LiveData<T>? = null,
//        context: CoroutineContext = Dispatchers.IO,
//        request: suspend CoroutineScope.() -> T
//    ): Job {
//        return viewModelScope.launch {
//            try {
//                withContext(context) { request() }.apply { liveData?.setValue(this) }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//
//    fun <T> LiveData<T>.setValue(value: T) {
//        (this as? MutableLiveData)?.value = value
//    }
}