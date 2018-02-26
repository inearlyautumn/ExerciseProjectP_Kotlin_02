package com.will.weiyuekotlin

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager
import com.will.weiyuekotlin.component.ApplicationComponent
import com.will.weiyuekotlin.component.DaggerApplicationComponent
import com.will.weiyuekotlin.module.ApplicationModule
import com.will.weiyuekotlin.module.HttpModule
import org.litepal.LitePal
import org.litepal.LitePalApplication
import kotlin.properties.Delegates

/**
 *
 * author: liweixing
 * date: 2018/2/24
 */
class MyApp : LitePalApplication() {
    companion object {
        var instance: MyApp by Delegates.notNull()
        var mApplicationComponent: ApplicationComponent by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .httpModule(HttpModule())
                .build()
        //初始化数据
        LitePal.initialize(this)
        //初始化侧滑返回组件
        BGASwipeBackManager.getInstance().init(this)
    }
}