package com.malik.coinfo.ui.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import com.malik.coinfo.R
import com.malik.coinfo.databinding.FragmentHomeBinding
import com.malik.coinfo.ui.BaseFragment
import com.malik.coinfo.ui.uimodel.chart.ChartPeriod
import com.malik.coinfo.ui.view.spinner.ChartPeriodSpinnerAdapter
import com.malik.coinfo.ui.view.spinner.SpinnerItemSelectedListener

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home, HomeViewModel::class.java) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.priceValueLiveData.observe(this, Observer { t -> binding.priceDataResource = t })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.timePeriodSpinner.onItemSelectedListener = object : SpinnerItemSelectedListener() {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                viewModel.setPeriod(ChartPeriod.values()[position])
            }
        }
        activity?.let {
            val spinnerAdapter = ChartPeriodSpinnerAdapter(it,
                    R.layout.support_simple_spinner_dropdown_item, android.R.id.text1, ChartPeriod.values())
            binding.timePeriodSpinner.adapter = spinnerAdapter
            binding.timePeriodSpinner.setSelection(0)
        }


    }
}