package com.will.weiyuekotlin.module

import android.content.Context
import com.will.weiyuekotlin.MyApp
import dagger.Provides

/**
 *
 * author: liweixing
 * date: 2018/2/24
 */
class ApplicationModule(private val mContext: Context) {

    @Provides
    internal fun provideApplication(): MyApp {
        return mContext.applicationContext as MyApp
    }

    @Provides
    internal fun provideContext(): Context {
        return mContext;
    }
}
