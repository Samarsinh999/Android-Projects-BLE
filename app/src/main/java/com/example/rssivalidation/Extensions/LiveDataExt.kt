package com.example.rssivalidation.Extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> LiveData<T>.asMutableLiveData(): MutableLiveData<T>? {
    return if (this is MutableLiveData<T>)
        this
    else null
}

