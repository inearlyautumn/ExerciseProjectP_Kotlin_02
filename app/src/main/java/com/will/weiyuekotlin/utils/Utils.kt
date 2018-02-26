package com.will.weiyuekotlin.utils

import android.content.Context
import android.widget.Toast

/**
 *
 * author: liweixing
 * date: 2018/2/26
 */
fun toast(context: Context, message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, length).show()
}