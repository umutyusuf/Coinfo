package com.malik.coinfo.ui.uimodel

class DataResource<T> private constructor(private val dataState: ResourceState,
                                          private val beanData: T?,
                                          private val error: Error?) : Resource<T> {

    companion object {
        fun <T> success(data: T?) = DataResource(ResourceState.SUCCESS, data, null)

        fun <T> error(data: T?, error: Error?) = DataResource(ResourceState.ERROR, data, error)

        fun <T> fetching(data: T?) = DataResource(ResourceState.FETCHING, data, null)
    }

    override fun getData(): T? = beanData

    override fun getState(): ResourceState = dataState

    override fun hasError(): Boolean = error != null

    override fun getError(): Error? = error
}