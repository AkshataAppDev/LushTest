package com.lush.practicaltest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lush.practicaltest.adapter.RocketListAdapter
import com.lush.practicaltest.api.response.RocketDataResponse
import com.lush.practicaltest.databinding.ActivityMainBinding
import com.lush.practicaltest.util.Resource
import com.lush.practicaltest.viewmodel.RocketListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RocketListViewModel by viewModels()
    private lateinit var adapter: RocketListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


        adapter = RocketListAdapter(
            mutableListOf(),
            this,
            object : RocketListAdapter.OnItemClickListener {
                override fun onItemCLick(
                    item: RocketDataResponse.RocketDataResponseItem
                ) {
                }

            })
        binding.rvRocketList.adapter = adapter

        getRocketList()
    }

    private fun getRocketList() {

        viewModel.getRocketList().observe(this, {
            when (it.status) {
                Resource.Status.SUCCESS -> {

                    binding.pbLoading.visibility = View.GONE
                    binding.rvRocketList.visibility = View.VISIBLE

                    adapter.setData(it.data)

                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.pbLoading.visibility = View.VISIBLE
                    binding.rvRocketList.visibility = View.GONE
                }
            }
        })
    }
}