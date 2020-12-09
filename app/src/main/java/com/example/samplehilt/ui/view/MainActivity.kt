package com.example.samplehilt.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplehilt.R
import com.example.samplehilt.data.model.User
import com.example.samplehilt.databinding.ActivityMainBinding
import com.example.samplehilt.ui.adapter.MainAdapter
import com.example.samplehilt.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainAdapter = MainAdapter()
        setObserver()
        setupUI(binding,mainAdapter)

    }

    private fun setObserver(){
        viewModel.errorMessage.observe(this){ Toast.makeText(this,it,Toast.LENGTH_SHORT).show()}
        viewModel.users.observe(this){
            renderList(it)
        }
    }

    private fun setupUI(binding: ActivityMainBinding , mainAdapter: MainAdapter) {
        binding.mainRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity,LinearLayoutManager.VERTICAL))
        }
    }

    private fun renderList(users : List<User>){
        mainAdapter.addData(users)
        mainAdapter.notifyDataSetChanged()
    }
}