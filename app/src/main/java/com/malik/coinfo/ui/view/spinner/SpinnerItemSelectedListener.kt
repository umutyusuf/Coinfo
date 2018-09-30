package com.malik.coinfo.ui.view.spinner

import android.widget.AdapterView

abstract class SpinnerItemSelectedListener : AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) {
        // no-op
    }
}