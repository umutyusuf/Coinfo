package com.malik.coinfo.ui.view.spinner

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.malik.coinfo.ui.uimodel.chart.ChartPeriod

open class ChartPeriodSpinnerAdapter
(context: Context, layoutRes: Int,
 private val textViewRes: Int,
 private val values: Array<ChartPeriod>) : ArrayAdapter<ChartPeriod>(context, layoutRes, textViewRes, values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View =
            setTextAndGetView(super.getView(position, convertView, parent), position)


    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View =
            setTextAndGetView(super.getDropDownView(position, convertView, parent), position)

    private fun setTextAndGetView(view: View, position: Int): View {
        val textView = view.findViewById<TextView>(textViewRes)
        textView.text = context.getString(values[position].displayTextRes)
        return view
    }
}