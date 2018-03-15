package com.will.weiyuekotlin.net

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import org.jetbrains.annotations.NonNls

/**
 *
 * author: liweixing
 * date: 2018/3/15
 */
abstract class BaseObserver<T> : Observer<T> {
    abstract fun onSuccess(t: T?)

    abstract fun onFail(e: Throwable)

    override fun onSubscribe(@NonNull d: Disposable) {}

    override fun onNext(@NonNull t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFail(e)
    }

    override fun onComplete() {}
}