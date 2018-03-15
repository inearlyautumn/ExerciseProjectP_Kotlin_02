package com.will.weiyuekotlin.widget

import android.content.Context
import android.media.RemoteController
import android.support.v7.widget.RecyclerView
import android.view.View
import com.flyco.dialog.widget.popup.base.BasePopup

/**
 *
 * author: liweixing
 * date: 2018/3/15
 */
class NewsDelPop(context: Context) : BasePopup<NewsDelPop>(context) {

    private lateinit var recyclerView: RecyclerView
    private var mOnClickListener: View.OnClickListener? = null

    fun setOnClickListener(onClickListener: View.OnClickListener) {
        mOnClickListener = onClickListener
    }
}