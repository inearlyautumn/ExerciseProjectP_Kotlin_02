package com.will.weiyuekotlin.ui.news.contract

import com.will.weiyuekotlin.bean.Channel
import com.will.weiyuekotlin.ui.base.BaseContract

/**
 *
 * author: liweixing
 * date: 2018/2/28
 */
interface NewsContract {
    interface View : BaseContract.BaseView {
        fun loadData(channels: List<Channel>, otherChannels: List<Channel>)
    }

    interface Presenter : BaseContract.BasePresenter {
        //获取频道列表
        fun getChannel()
    }
}