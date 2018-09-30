package com.malik.commons

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.moveSubscribeToBackground(scheduler: Scheduler): Observable<T> =
        subscribeOn(Schedulers.newThread()).observeOn(scheduler)