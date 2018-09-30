package com.malik.coinfo.ui.uimodel

interface Resource<T> {
    fun getData(): T?

    fun getState(): ResourceState

    fun hasError(): Boolean

    fun getError(): Error?
}