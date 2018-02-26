package com.will.weiyuekotlin.utils

import android.app.Activity
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.IntRange
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