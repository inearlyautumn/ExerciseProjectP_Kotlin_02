package com.will.weiyuekotlin.ui.news

import android.os.Bundle
import android.view.View
import com.will.weiyuekotlin.bean.NewsDetail
import com.will.weiyuekotlin.component.ApplicationComponent
import com.will.weiyuekotlin.ui.adapter.NewsDetailAdapter
import com.will.weiyuekotlin.ui.base.BaseFragment
import com.will.weiyuekotlin.ui.news.contract.DetailContract
import com.will.weiyuekotlin.ui.news.presenter.DetailPresenter
import com.will.weiyuekotlin.widget.SimpleMultiStateView
import com.youth.banner.Banner

/**
 *
 * author: liweixing
 * date: 2018/3/1
 */
class DetailFragment : BaseFragment<DetailPresenter>(), DetailContract.View {

    private var mBannerList: MutableList<NewsDetail.ItemBean>? = mutableListOf()
    private var detailAdapter: NewsDetailAdapter? = null
    private var newsId: String? = null
    private var upPullNum = 1
    private var downPullNum = 1
    private var isRemoveHeaderView = false
    private var viewFocus: View? = null
    private var mBanner: Banner? = null
    private var newsDelPop: NewsDelPop? = null

    override fun getContentLayout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBannerData(newsDetail: NewsDetail?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSimpleMultiStateView(): SimpleMultiStateView? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadTopNewsData(newsDetail: NewsDetail?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initInjector(appComponent: ApplicationComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadData(itemBeanList: List<NewsDetail.ItemBean>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadMoreData(itemBeanList: List<NewsDetail.ItemBean>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}