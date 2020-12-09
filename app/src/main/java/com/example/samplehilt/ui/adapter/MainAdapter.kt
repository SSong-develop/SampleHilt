package com.example.samplehilt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplehilt.R
import com.example.samplehilt.data.model.User
import com.example.samplehilt.databinding.ItemViewBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.itemViewHolder>() {

    var data = arrayListOf<User>()

    inner class itemViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(users: User) {
            binding.user = users
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_view,parent,false)
        return itemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun addData(userList : List<User>){
        data.addAll(userList)
    }
}