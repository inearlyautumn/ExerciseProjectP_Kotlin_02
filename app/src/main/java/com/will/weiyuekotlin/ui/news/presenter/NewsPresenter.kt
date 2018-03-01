package com.will.weiyuekotlin.ui.news.presenter

import com.will.weiyuekotlin.MyApp
import com.will.weiyuekotlin.R
import com.will.weiyuekotlin.bean.Channel
import com.will.weiyuekotlin.databaase.ChannelDao
import com.will.weiyuekotlin.ui.base.BasePresenter
import com.will.weiyuekotlin.ui.news.contract.NewsContract
import org.litepal.crud.DataSupport
import javax.inject.Inject

/**
 *
 * author: liweixing
 * date: 2018/2/28
 */
class NewsPresenter @Inject constructor() : BasePresenter<NewsContract.View>(), NewsContract.Presenter {
    /**
     * 获取频道列表
     */
    override fun getChannel() {
        var channelList: MutableList<Channel>
        val myChannels = ArrayList<Channel>()
        val otherChannels = ArrayList<Channel>()
        channelList = ChannelDao.channels as MutableList<Channel>
        when {
            channelList.size < 1 -> {
                val channelName = MyApp.instance.resources.getStringArray(R.array.news_channel)
                val channelId = MyApp.instance.resources.getStringArray(R.array.news_channel_id)
                val channels = ArrayList<Channel>()

                for (i in channelName.indices) {
                    val channel = Channel()
                    channel.channelId = channelId[i].toString()
                    channel.channelName = channelName[i].toString()
                    channel.channelType = if (i < 1) 1 else 0//默认第一个频道不可先移除
                    channel.isChannelSelect = i < channelName.size - 3 //默认后三个频道为未选中状态

                    when {
                        i < channelId.size - 3 -> myChannels.add(channel)
                        else -> otherChannels.add(channel)
                    }
                    channels.add(channel)
                }
                //存入数据库
                DataSupport.saveAllAsync(channels)
                channelList = ArrayList()
                channelList.addAll(channels)
            }
            else -> {
                channelList = ChannelDao.channels as MutableList<Channel>
                val iterator = channelList.iterator()
                while (iterator.hasNext()) {
                    val channel = iterator.next()
                    if (!channel.isChannelSelect) {
                        otherChannels.add(channel)
                        iterator.remove()
                    }
                }
                myChannels.addAll(channelList)
            }
        }
        mView?.loadData(myChannels, otherChannels)
    }
}