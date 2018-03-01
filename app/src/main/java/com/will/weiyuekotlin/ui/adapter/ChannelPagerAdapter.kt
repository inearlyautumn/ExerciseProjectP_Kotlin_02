package com.will.weiyuekotlin.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.will.weiyuekotlin.bean.Channel
import com.will.weiyuekotlin.ui.base.BaseFragment
import com.will.weiyuekotlin.ui.video.DetailFragment_MembersInjector

/**
 *
 * author: liweixing
 * date: 2018/3/1
 */
class ChannelPagerAdapter(fm:FragmentManager, private var mChannels: List<Channel>):FragmentStatePagerAdapter(fm) {

    fun updateChannel(channels: List<Channel>) {
        this.mChannels = channels
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): BaseFragment<*> = DetailFragment

    override fun getCount(): Int {
    }

}