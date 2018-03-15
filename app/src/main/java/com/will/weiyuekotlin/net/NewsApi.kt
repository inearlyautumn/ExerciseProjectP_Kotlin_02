package com.will.weiyuekotlin.net

import android.support.annotation.StringDef
import android.support.v7.widget.RecyclerView
import com.will.weiyuekotlin.bean.NewsDetail
import com.will.weiyuekotlin.bean.VideoChannelBean
import io.reactivex.Observable
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 *
 * author: liweixing
 * date: 2018/2/24
 */
class NewsApi(private val mService: NewsApiService) {

    companion object {
        const val ACTION_DEFAULT = "default"
        const val ACTION_DOWN = "down"
        const val ACTION_UP = "up"

        private var sInstance: NewsApi? = null

        fun getInstance(newsApiService: NewsApiService): NewsApi {
            if (sInstance == null) {
                sInstance = NewsApi(newsApiService)
            }
            return sInstance as NewsApi
        }
    }

    @StringDef(ACTION_DEFAULT, ACTION_DOWN, ACTION_UP)
    @Retention(RetentionPolicy.SOURCE)
    annotation class Actions

    /*
    * 获取新闻详情
    * */
    fun getNewsDetail(id: String, @Actions action: String, pullNum: Int): Observable<List<NewsDetail>>
            = mService.getNewsDetail(id, action, pullNum)

//    /**
//     * 获取视频频道列表
//     * */
//    val videoChannel: Observable<List<VideoChannelBean>>
//    get() = mService.getVideoChannel(1)
}