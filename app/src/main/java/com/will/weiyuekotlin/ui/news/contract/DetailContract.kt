package com.will.weiyuekotlin.ui.news.contract

import com.will.weiyuekotlin.bean.NewsDetail
import com.will.weiyuekotlin.ui.base.BaseContract

/**
 *
 * author: liweixing
 * date: 2018/3/1
 */
interface DetailContract {

    interface View : BaseContract.BaseView {
        /**
         * 加载顶部Banner数据
         * */
        fun loadBannerData(newsDetail: NewsDetail?)

        /**
         * 加载置顶新闻数据
         */
        fun loadTopNewsData(newsDetail: NewsDetail?)

        /**
         * 加载新闻数据
         */
        fun loadData(itemBeanList: List<NewsDetail.ItemBean>?)

        /*
        * 加载更多新闻数据
        * */
        fun loadMoreData(itemBeanList: List<NewsDetail.ItemBean>?)
    }

    interface Presenter : BaseContract.BasePresenter {
        /*
        * 获取新闻详细信息
        * */
        fun getData(id: String, action: String, pullNum: Int)
    }
}