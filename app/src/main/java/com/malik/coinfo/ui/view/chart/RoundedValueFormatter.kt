package com.malik.coinfo.ui.view.chart

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class RoundedValueFormatter : IndexAxisValueFormatter() {

    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        return Math.round(value).toString()
    }
}