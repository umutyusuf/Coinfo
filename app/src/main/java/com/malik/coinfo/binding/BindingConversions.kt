package com.malik.coinfo.binding

import android.view.View
import androidx.databinding.BindingConversion
import com.malik.coinfo.ui.uimodel.Resource
import com.malik.coinfo.ui.uimodel.ResourceState

object BindingConversions {
    @JvmStatic
    @BindingConversion
    fun <T> bindBeanToProgress(bean: Resource<T>?): Int =
            if (bean?.getState() == ResourceState.FETCHING && bean.getData() == null) View.VISIBLE else View.GONE

    @JvmStatic
    @BindingConversion
    fun bindBooleanToVisibility(isVisible: Boolean): Int = if (isVisible) View.VISIBLE else View.GONE
}