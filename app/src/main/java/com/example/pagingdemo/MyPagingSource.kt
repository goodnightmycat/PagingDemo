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
        return null
    }

    private var currentKey = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Student> {
        Log.e("MyPagingSource", "load->key:${params.key}")
        val list = ArrayList<Student>()
        //params.loadSize默认值为PagingConfig.pageSize*3，构造函数传值initialLoadSize覆盖。
        if (params.key == null) {
            for (i in 0..params.loadSize) {
                val student = Student()
                student.name = CHEESE_DATA[i]
                list.add(student)
            }

        } else {
            for (i in 20..30) {
                val student = Student()
                student.name = CHEESE_DATA[i]
                list.add(student)
            }
        }
        currentKey++

        return LoadResult.Page(data = list, prevKey = null, nextKey = currentKey)
    }


}