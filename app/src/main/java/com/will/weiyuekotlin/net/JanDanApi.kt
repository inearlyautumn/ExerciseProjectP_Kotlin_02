package com.will.weiyuekotlin.net

import android.support.annotation.StringDef
import com.will.weiyuekotlin.bean.FreshNewsBean
import io.reactivex.Observable
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 *
 * author: liweixing
 * date: 2018/2/24
 */
class JanDanApi(private val mService: JanDanApiService) {

    companion object {
        /**
         * 新鲜事
         */
        const val TYPE_FRESH = "get_recent_posts"
        /**
         * 新鲜事文章
         */
        const val TYPE_FRESHARTICLE = "get_post"
        /**
         * 无聊图
         */
        const val TYPE_BORED = "jandan.get_pic_comments"
        /**
         * 妹子图
         */
        const val TYPE_GIRLS = "jandan.get_ooxx_comments"
        /**
         * 段子
         */
        const val TYPE_Duan = "jandan.get_duan_comments"

        private var sInstance: JanDanApi? = null

        fun getInstance(janDanApiService: JanDanApiService): JanDanApi {
            if (sInstance == null)
                sInstance = JanDanApi(janDanApiService)
            return sInstance as JanDanApi
        }
    }

    @StringDef(TYPE_FRESH, TYPE_BORED, TYPE_GIRLS, TYPE_Duan)
    @Retention(RetentionPolicy.SOURCE)
    annotation class Type


}