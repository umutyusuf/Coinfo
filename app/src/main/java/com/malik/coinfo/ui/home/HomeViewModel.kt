package com.malik.coinfo.ui.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malik.coinfo.ui.uimodel.DataResource
import com.malik.coinfo.ui.uimodel.Resource
import com.malik.coinfo.ui.uimodel.chart.ChartPeriod
import com.malik.commons.moveSubscribeToBackground
import com.malik.domain.price.BitcoinPriceRetrieveUseCase
import com.malik.model.PricePoint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class HomeViewModel @Inject
constructor(private val retrieveUseCase: BitcoinPriceRetrieveUseCase) : ViewModel() {
    internal val priceValueLiveData: MediatorLiveData<Resource<List<PricePoint>>> = MediatorLiveData()
    private val periodLiveData: MutableLiveData<ChartPeriod> = MutableLiveData()
    private val disposable = CompositeDisposable()

    init {
        priceValueLiveData.addSource(periodLiveData) { retrieveData(it) }
    }

    internal fun setPeriod(period: ChartPeriod) {
        periodLiveData.value = period
    }

    private fun retrieveData(period: ChartPeriod) {
        priceValueLiveData.value = DataResource.fetching(null)
        val observable = retrieveUseCase.retrieveBitcoinPrice(period.queryText)
                .moveSubscribeToBackground(AndroidSchedulers.mainThread())
                .flatMap { Observable.fromIterable(it.values) }
                .toList()
                .doOnSuccess { priceValueLiveData.value = DataResource.success(it) }
                .subscribe()
        disposable.add(observable)
    }

    override fun onCleared() {
        super.onCleared()
    }

}