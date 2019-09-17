package com.sample.android.commonadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hwangjr.rxbus.RxBus
import com.sample.android.commonadapter.data.Item

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: List<Item>? = null

    init {
        data = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_main,
                parent,
                false
            )
        )
    }

    fun setNewData(data: List<Item>) {
        this.data = ArrayList(data)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainHolder) {
            val item = data?.get(position)
            if (item != null) {
                holder.noView.text = item.uid
                holder.noView.setOnClickListener {
                    RxBus.get().post(Event.ON_ITEM_CLICK, item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noView = itemView.findViewById<TextView>(R.id.it_no)
    }
}
