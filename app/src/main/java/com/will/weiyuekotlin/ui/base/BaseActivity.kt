package com.will.weiyuekotlin.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.View
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper
import com.trello.rxlifecycle2.LifecycleTransformer
import com.will.weiyuekotlin.R
import com.will.weiyuekotlin.ui.listener.IBase
import com.will.weiyuekotlin.utils.toast
import com.will.weiyuekotlin.widget.SimpleMultiStateView
import javax.annotation.Nullable
import javax.inject.Inject

/**
 *
 * author: liweixing
 * date: 2018/2/24
 */
abstract class BaseActivity<T : BaseContract.BasePresenter> : SupportActivity(), IBase, BaseContract.BaseView,
        BGASwipeBackHelper.Delegate {
    private lateinit var mRootView: View
    lateinit var mLoadingDialog: Dialog
    lateinit var mSwipeBackHelper: BGASwipeBackHelper

    //这个写法有点不懂
    @Nullable
    private var mSimpleMultiStateView: SimpleMultiStateView? = null

    @Nullable
    @Inject
    @JvmField
    var mPresenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initSwipeBackFinish()
        super.onCreate(savedInstanceState)
    }

    /**
     * 初始化滑动返回，在 super.onCreate(saveInstanceState) 这前调用该方法
     */
    private fun initSwipeBackFinish() {
        mSwipeBackHelper = BGASwipeBackHelper(this, this)
        // [必须在 Application的 onCreate方法中执行 BGASwipBackManager.getInstance().init(this)来初始化滑动返回 ]
        //下面几项可以不配置，这里只是为了讲述接口用法
        //设置滑动返回是否可用，默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(true)
        //设置是否仅仅跟踪左侧边缘的滑动返回，默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(false)
        //设置是否是微信滑动返回样式，默认值为 true
        mSwipeBackHelper.setIsWeChatStyle(false)
        //设置阴影资源 id.默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow)
        //设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true)
        //设置阴影区域的透明度是否根据滑动的距离淅变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true)
        //设置解发释放后自动滑动返回的阈值，默认为 0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f)
    }

    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法
     * 返回 false 即可
     */
    override fun isSupportSwipeBack(): Boolean = true

    /**
     * 显示加载页面
     */
    override fun showLoading() {
        mSimpleMultiStateView?.showLoadingView()
    }

    /**
     * 显示内容页面
     */
    override fun showSuccess() {
        mSimpleMultiStateView?.showContent()
    }

    /**
     * 显示错误页面
     */
    override fun showError() {
        mSimpleMultiStateView?.showErrorView()
    }

    override fun showNoNet() {
        mSimpleMultiStateView?.showNoNetView()
    }

    /**
     * 绑定生命周期
     */
    override fun <T> bindToLife(): LifecycleTransformer<T> = this.bindToLifecycle()

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    override fun onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward()
    }

    protected fun toast(message: String) {
        toast(this, message)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.detachView()
    }
}