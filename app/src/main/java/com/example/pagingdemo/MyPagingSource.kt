package com.example.pagingdemo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

/**
 * @author fanxiaoyang
 * date 2021/10/19
 * desc 分页数据源
 */
class MyPagingSource : PagingSource<Int, Student>() {

    override fun getRefreshKey(state: PagingState<Int, Student>): Int? {
        return state.pages.size
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Student> {
        Log.e("hahaha", "aa${params.key?.toString()}")
        val list = ArrayList<Student>()
        for (i in 0..5) {
            val student = Student()
            student.name = CHEESE_DATA[i]
            list.add(student)
        }
        return LoadResult.Page(data = list, prevKey = 1, nextKey = 1)
    }


}