package com.will.weiyuekotlin

import android.os.Bundle
import android.view.View
import com.will.weiyuekotlin.ui.base.BaseActivity
import com.will.weiyuekotlin.ui.base.BaseContract
import com.will.weiyuekotlin.component.ApplicationComponent
import com.will.weiyuekotlin.ui.news.NewsFragment
import com.will.weiyuekotlin.utils.StatusBarUtil
import com.will.weiyuekotlin.widget.SimpleMultiStateView
import me.yokeyword.fragmentation.SupportFragment

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {
    private val mFragments = arrayOfNulls<SupportFragment>(4)

    override fun getContentLayout(): Int = R.layout.activity_main

    override fun getSimpleMultiStateView(): SimpleMultiStateView? = null

    override fun initInjector(appComponent: ApplicationComponent) {}

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        StatusBarUtil.setTranslucentForImageViewInfragment(this@MainActivity, 0, null)
        if (savedInstanceState == null) {
            mFragments[0] = NewsFragment
        }
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRetry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSwipeBackLayoutSlide(slideOffset: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSwipeBackLayoutCancel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
