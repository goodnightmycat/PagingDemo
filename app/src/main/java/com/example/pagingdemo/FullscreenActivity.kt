package com.example.pagingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {

    private val myAdapter = MyPagingDataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@FullscreenActivity)
            adapter = myAdapter
        }
    }

    val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application).create(MyViewModel::class.java)

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            try {
                viewModel.flow.collectLatest {
                    myAdapter.submitData(it)
                }
            } catch (e:Exception){
                e.printStackTrace()
            }

        }
    }

}