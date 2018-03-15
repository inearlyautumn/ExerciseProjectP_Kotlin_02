package com.will.weiyuekotlin.net

import com.will.weiyuekotlin.bean.NewsDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 *
 * author: liweixing
 * date: 2018/2/24
 */
interface NewsApiService {

    @GET("ClientNews")
    fun getNewsDetail(@Query("id") id: String,
                      @Query("action") action: String,
                      @Query("pullNum") pullNum: Int): Observable<List<NewsDetail>>
}