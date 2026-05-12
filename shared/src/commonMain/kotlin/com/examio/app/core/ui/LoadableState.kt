package com.examio.app.core.ui

sealed interface LoadableState<out T> {
    data object Idle : LoadableState<Nothing>
    data object Loading : LoadableState<Nothing>
    data object Empty : LoadableState<Nothing>
    data class Data<T>(val value: T) : LoadableState<T>
    data class Error(val message: String) : LoadableState<Nothing>
}
