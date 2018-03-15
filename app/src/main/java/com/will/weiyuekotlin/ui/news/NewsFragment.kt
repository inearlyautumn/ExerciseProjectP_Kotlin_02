package com.will.weiyuekotlin.ui.news

import android.os.Bundle
import android.view.View
import com.will.weiyuekotlin.bean.Channel
import com.will.weiyuekotlin.component.ApplicationComponent
import com.will.weiyuekotlin.ui.adapter.ChannelPagerAdapter
import com.will.weiyuekotlin.ui.base.BaseFragment
import com.will.weiyuekotlin.ui.news.contract.NewsContract
import com.will.weiyuekotlin.ui.news.presenter.NewsPresenter
import com.will.weiyuekotlin.widget.SimpleMultiStateView

/**
 *
 * author: liweixing
 * date: 2018/2/27
 */
class NewsFragment : BaseFragment<NewsPresenter>(), NewsContract.View {
    private var mSelectedData: MutableList<Channel>? = null
    private var mUnSelectedData: MutableList<Channel>? = null
    private var selectedIndex: Int = 0
    private var mChannelPagerAdapter: ChannelPagerAdapter = null

    override fun loadData(channels: List<Channel>, otherChannels: List<Channel>) {

    }

    override fun getContentLayout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSimpleMultiStateView(): SimpleMultiStateView? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initInjector(appComponent: ApplicationComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var mSelectedData: MutableList<Channel>? = null

}