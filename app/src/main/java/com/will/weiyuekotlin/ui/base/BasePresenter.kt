package com.will.weiyuekotlin.ui.base

/**
 *
 * author: liweixing
 * date: 2018/2/28
 */
abstract class BasePresenter<T> : BaseContract.BasePresenter {
    protected var mView: T? = null

    //绑定 view
    override fun attachView(view: BaseContract.BaseView) {
        this.mView = view as T
    }

    //解绑
    override fun detachView() {
        mView.let { mView = null }
    }
}