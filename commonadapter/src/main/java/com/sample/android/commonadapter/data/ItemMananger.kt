package com.sample.android.commonadapter.data

import java.util.ArrayList

class ItemMananger(data: List<Item>) {

    private var data: List<Item>? = null

    init {
        this.data = ArrayList(data)
    }
}
