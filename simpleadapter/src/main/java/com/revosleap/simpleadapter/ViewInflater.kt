package com.revosleap.simpleadapter

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false): View{
    return LayoutInflater.from(context).inflate(layout,this, attachToRoot)
}