package com.will.weiyuekotlin.ui.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.trello.rxlifecycle2.components.support.RxFragment
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SupportFragmentDelegate
import me.yokeyword.fragmentation.anim.FragmentAnimator

/**
 *
 * author: liweixing
 * date: 2018/2/28
 */
open class SupportFragment : RxFragment(), ISupportFragment {
    private val mDelegate = SupportFragmentDelegate(this)
    private lateinit var _mActivity: FragmentActivity

    override fun getSupportDelegate(): SupportFragmentDelegate {
        return mDelegate
    }

    /**
     * perform some extra transactions.
     * 额外的事务：自定义Tag，添加SharedElement动画，操作非回退栈Fragment
     */
    override fun extraTransaction(): ExtraTransaction = mDelegate.extraTransaction()

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        mDelegate.onAttach(activity)
        _mActivity = mDelegate.activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDelegate.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mDelegate.onActivityCreated(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        mDelegate.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        mDelegate.onResume()
    }

    override fun onPause() {
        super.onPause()
        mDelegate.onPause()
    }

    override fun onDestroyView() {
        mDelegate.onDestroyView()
        super.onDestroyView()
    }

    override fun onDestroy() {
        mDelegate.onDestroy()
        super.onDestroy()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        mDelegate.onHiddenChanged(hidden)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mDelegate.setUserVisibleHint(isVisibleToUser)
    }

    /**
     * called when the enter-animation end.
     * 入栈动画 结束时，回调
     */
    override fun onEnterAnimationEnd(savedInstanceState: Bundle?) {
        mDelegate.onEnterAnimationEnd(savedInstanceState)
    }

    /**
     * Lazy initial, Called when fragment is first called.
     * 同级下的 懒加载+ViewPager下的懒加载 的结合回调方法
     */
    override fun onLazyInitView(savedInstanceState: Bundle?) {
        mDelegate.onLazyInitView(savedInstanceState)
    }

    /**
     * called when the fragment is visible.
     * 当Fragment对用户可见时回调
     */
    override fun onSupportVisible() {
        mDelegate.onSupportVisible()
    }

    /**
     * Called when the fragment is invisible.
     */
    override fun onSupportInvisible() {
        mDelegate.onSupportInvisible()
    }

    /**
     * return the if the fragmnet has been supportVisible
     */
    override fun isSupportVisible(): Boolean = mDelegate.isSupportVisible

    /**
     * Set fragment animation with a higher priority than the ISupportActivity
     * 设定当前Fragment动画，优先级比在SupportActivity要高
     */
    override fun onCreateFragmentAnimator(): FragmentAnimator = mDelegate.onCreateFragmentAnimator()

    /**
     * 获取设置的全局动画 copy
     */
    override fun getFragmentAnimator(): FragmentAnimator = mDelegate.fragmentAnimator

    /**
     * 设置 Fragment内的全局动画
     */
    override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator?) {
        mDelegate.fragmentAnimator = fragmentAnimator
    }

    /**
     * 按返回键触发，前提是SupportActivity的 onBackPressed() 方法能被调用
     * @return false则继续向上传递，true则消费掉该事件
     */
    override fun onBackPressedSupport(): Boolean = mDelegate.onBackPressedSupport()

    /**
     * 类似 [Activity.setResult]
     */
    override fun setFragmentResult(resultCode: Int, bundle: Bundle?) {
        mDelegate.setFragmentResult(resultCode, bundle)
    }

    /**
     * 类似 [Activity.onActivityResult]
     */
    override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle?) {
        mDelegate.onFragmentResult(requestCode, resultCode, data)
    }

    /**
     * 在 start(TargetFragment, LaunchMode) 时，启动模式为 SingleTask/SingleTop，回调TargetFragment的该方法
     * 类似 [Activity.onNewIntent]
     */
    override fun onNewBundle(args: Bundle?) {
        mDelegate.onNewBundle(args)
    }

    /**
     * 添加NewBundle，用于启动模式为 SingleTask/SingleTop 时
     */
    override fun putNewBundle(newBundle: Bundle?) {
        mDelegate.putNewBundle(newBundle)
    }
}