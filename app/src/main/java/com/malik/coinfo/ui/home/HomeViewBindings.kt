package com.malik.coinfo.ui.home

import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.malik.coinfo.R
import com.malik.coinfo.ui.view.chart.ChartValueDateFormatter
import com.malik.coinfo.ui.view.chart.RoundedValueFormatter
import com.malik.model.PricePoint

private const val DEFAULT_DATE_FORMAT = "dd.MM.yy"

@BindingAdapter(value = ["priceValues", "chartLabel"], requireAll = false)
fun bindDefaultLineChart(chartView: LineChart,
                         priceValues: List<PricePoint>?,
                         label: String?) {
    if (priceValues == null) {
        return
    }

    val chartPriceValues = ArrayList<Entry>()
    for (pricePoint in priceValues) {
        pricePoint.timestamp?.let { timestamp ->
            pricePoint.price?.let { price ->
                val entry = Entry(timestamp.toFloat(), price)
                chartPriceValues.add(entry)
            }
        }
    }

    chartView.xAxis.valueFormatter = ChartValueDateFormatter(DEFAULT_DATE_FORMAT)
    chartView.axisLeft.valueFormatter = RoundedValueFormatter()

    val dataSet = LineDataSet(chartPriceValues, label).apply {
        axisDependency = YAxis.AxisDependency.LEFT
        color = ContextCompat.getColor(chartView.context, R.color.colorAccent)
        formLineWidth = 2f
        setDrawIcons(true)
        setDrawValues(false)
    }

    val lineData = LineData(dataSet)
    chartView.data = lineData
}
