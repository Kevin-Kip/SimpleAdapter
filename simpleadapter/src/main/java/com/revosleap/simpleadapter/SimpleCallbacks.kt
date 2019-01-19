package com.revosleap.simpleadapter

import android.view.View

interface SimpleCallbacks{
    fun onViewClicked(view: View, item: Any, position: Int)
    fun bindView(view: View, item: Any, position: Int)
    fun onViewLongClicked(it: View?, item: Any, position: Int)
}