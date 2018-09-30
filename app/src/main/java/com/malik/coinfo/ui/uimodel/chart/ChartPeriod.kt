package com.malik.coinfo.ui.uimodel.chart

import androidx.annotation.StringRes
import com.malik.coinfo.R

enum class ChartPeriod(val queryText: String, @StringRes val displayTextRes: Int) {
    WEEK("1weeks", R.string.one_week),
    MONTH_1("1months", R.string.one_month),
    MONTH_3("3months", R.string.three_months),
    MONTH_6("6months", R.string.six_months),
    YEAR("1years", R.string.one_years),;

    override fun toString(): String {
        return super.toString()
    }
}