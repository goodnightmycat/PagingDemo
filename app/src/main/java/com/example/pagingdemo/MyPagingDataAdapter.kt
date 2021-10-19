package com.example.pagingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyPagingDataAdapter() : PagingDataAdapter<Student, MyPagingDataAdapter.MyPagingViewHolder>(diffCallback) {

    private companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean =
                oldItem.name == newItem.name
        }
    }

    inner class MyPagingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)

        fun setText(text: String?) {
            textView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_page_list, parent, false)
        return MyPagingViewHolder(view)
    }

    override fun onBindViewHolder(holderMyPaging: MyPagingViewHolder, position: Int) {
        holderMyPaging.setText("我是第${position}位学生：${getItem(position)?.name}")
    }

}