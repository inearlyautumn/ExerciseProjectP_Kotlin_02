package com.will.weiyuekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.will.weiyuekotlin.base.BaseActivity
import com.will.weiyuekotlin.base.BaseContract
import com.will.weiyuekotlin.component.ApplicationComponent
import com.will.weiyuekotlin.utils.ImageLoaderUtil
import com.will.weiyuekotlin.widget.SimpleMultiStateView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_welcome.*
import pl.droidsonroids.gif.GifDrawable
import java.util.concurrent.TimeUnit

class WelcomeActivity : BaseActivity<BaseContract.BasePresenter>() {
    //必应每日壁纸 来源于 https://www.dujin.org/fenxiang/jiaocheng/3618.html.
    private val picUrl = "http://api.dujin.org/bing/1920.php"

    private val mCompositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun getContentLayout(): Int = R.layout.activity_welcome

    override fun getSimpleMultiStateView(): SimpleMultiStateView? = null

    override fun initInjector(appComponent: ApplicationComponent) {
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        val gifDrawable = gifImageView.drawable as GifDrawable
        gifDrawable.loopCount = 1
        gifImageView.postDelayed({ gifDrawable.start() }, 100)

        ImageLoaderUtil.LoadImage(this, picUrl, iv_ad)
        mCompositeDisposable?.add(countDown(3))
    }

    /**
     * 倒计时
     * @param time 秒
     */
    private fun countDown(time: Int): Observable<Int> {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map { t -> time - t.toInt() }
                .take((time + 1).toLong())
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRetry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSwipeBackLayoutSlide(slideOffset: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSwipeBackLayoutCancel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }
}
