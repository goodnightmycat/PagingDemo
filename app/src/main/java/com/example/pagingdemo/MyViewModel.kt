package com.example.pagingdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*

class MyViewModel : ViewModel() {

    val pager = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 3)
    ) {
        MyPagingSource()
    }

    val flow = pager.flow.cachedIn(viewModelScope)

    val liveData = pager.liveData


}