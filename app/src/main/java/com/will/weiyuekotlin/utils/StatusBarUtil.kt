package com.will.weiyuekotlin.utils

import android.app.Activity
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.IntRange
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.will.weiyuekotlin.R
import com.will.weiyuekotlin.WelcomeActivity

/**
 *
 * author: liweixing
 * date: 2018/2/26
 */
object StatusBarUtil {

    val DEFAULT_STATUS_BAR_ALPHA = 112
    private val FAKE_STATUS_BAR_VIEW_ID = R.id.statusbarutil_fake_status_bar_view
    private val FAKE_TRANSLUCENT_VIEW_ID = R.id.statusbarutil_translucent_view
    private val TAG_KEY_HAVE_SET_OFFSET = -123
    /**
     * 为 fragment 头部是 ImageView 的设置状态栏透明
     * @param activity   fragment 对应的 activity
     * @param statusBarAlpha  状态栏透明度
     * @param needOffsetView  需要向下偏移的 view
     */
    fun setTranslucentForImageViewInfragment(activity: Activity, @IntRange(from = 0, to = 255) statusBarAlpha: Int,
                                             needOffsetView: View?) {
        setTranslucentForImageViewInfragment(activity, statusBarAlpha, needOffsetView)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            clearPreviousSetting(activity)
        }
    }

    private fun clearPreviousSetting(activity: Activity) {
        val decorView = activity.window.decorView as ViewGroup
        val fakeStatusBarView = decorView.findViewById<View>(FAKE_STATUS_BAR_VIEW_ID)
        if (fakeStatusBarView != null) {
            decorView.removeView(fakeStatusBarView)
            val rootView = (activity.findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
            rootView.setPadding(0, 0, 0, 0)
        }
    }

//    /**
//     * 设置状态栏颜色
//     */
//    @JvmOverloads
//    fun setColor(activity: Activity, @ColorInt color: Int, @IntRange(from = 0, to = 255) statusBarAlpha: Int = DEFAULT_STATUS_BAR_ALPHA) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            activity.window.statusBarColor = cal
//        }
//    }

}