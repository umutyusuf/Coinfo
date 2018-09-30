package com.malik.coinfo.ui.view.chart

import android.content.Context
import android.util.AttributeSet
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.malik.coinfo.R

class CoinfoLineChart @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : LineChart(context, attrs, defStyle) {

    init {
        setupChart()
    }

    private fun setupChart() {

        // Init Description
        val description = Description().apply {
            isEnabled = false
        }
        setDescription(description)

        // Init GridBackground
        setGridBackgroundColor(android.R.color.white)
        setDrawGridBackground(true)

        // Init Borders
        setDrawBorders(true)
        setBorderColor(android.R.color.black)
        setBorderWidth(1f)

        // Init Other Properties
        setPinchZoom(false)
        isDoubleTapToZoomEnabled = false
        isDragEnabled = true
        setNoDataText(context.getString(R.string.data_unavailable_text))
        setScaleEnabled(true)

        // Init Legend
        legend.isEnabled = false

        // Init xAxis
        with(xAxis) {
            isEnabled = true
            setCenterAxisLabels(false)
            gridColor = android.R.color.white
            setAvoidFirstLastClipping(false)
            setDrawLimitLinesBehindData(true)
            position = XAxis.XAxisPosition.BOTTOM
        }


        // Init leftAxis
        with(axisLeft) {
            axisMinimum = 0f
            setDrawAxisLine(false)
            setDrawZeroLine(true)
            setDrawGridLines(true)
            gridColor = android.R.color.black
            axisLineColor = android.R.color.black
        }

        axisRight.isEnabled = false
    }
}