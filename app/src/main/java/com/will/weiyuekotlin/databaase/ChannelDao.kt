package com.will.weiyuekotlin.databaase

import com.will.weiyuekotlin.bean.Channel
import org.litepal.crud.DataSupport

/**
 *
 * author: liweixing
 * date: 2018/3/1
 */
object ChannelDao {
    //获取所有频道
    val channels: List<Channel> get() = DataSupport.findAll(Channel::class.java)

    //保存所有的频道
    fun saveChannels(channels: List<Channel>) {
        if (channels == null) {
            return
        }
        if (channels.size > 0) {
            val channelList = ArrayList<Channel>()
            channelList.addAll(channels)
            DataSupport.deleteAllAsync(Channel::class.java).listen {
                /*
                * 因为model之前被存储过了，再次存储就存不进去了
                * 单个model调用一下 clearSavedState方法就可以了，
                * 集合的话调用markAsDeleted方法。
                * */
                DataSupport.markAsDeleted(channelList)
                DataSupport.saveAllAsync(channelList).listen { }
            }
        }
    }

    /**
     * 清空所有频道
     */
    fun cleanChanels() {
        DataSupport.deleteAll(Channel::class.java)
    }
}