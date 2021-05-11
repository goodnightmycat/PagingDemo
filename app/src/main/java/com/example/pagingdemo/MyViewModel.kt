package com.example.pagingdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList

class MyViewModel : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 15
        private const val ENABLE_PLACEHOLDERS = false
    }

    val myPagingConfig = PagedList.Config.Builder()       // 分页设置
        .setPageSize(10)//一页多少个
        .setPrefetchDistance(5)
        .setEnablePlaceholders(true)
        .setInitialLoadSizeHint(40)
        .build()
    val myConcertDataSource = MyDataSourceFactory()
    val concertList = LivePagedListBuilder(myConcertDataSource, myPagingConfig).build()

    fun loadMore() {

    }

}