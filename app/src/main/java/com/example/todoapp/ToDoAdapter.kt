package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.todoapp.databinding.ItemListBinding
import java.text.FieldPosition

class ToDoAdapter(private val list:MutableList<ItemDataModel>): RecyclerView.Adapter<ToDoAdapter.MyListViewHolder>() {
    inner class MyListViewHolder(private val binding:ItemListBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(getList: ItemDataModel) {
            binding.textView3.text = getList.title
            binding.textView4.text = getList.description

            binding.imageButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    list.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }
    override  fun onCreateViewHolder(parent: ViewGroup,viewType:Int):ToDoAdapter.MyListViewHolder{
            val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            return MyListViewHolder(binding)
    }
    override fun onBindViewHolder(holder:ToDoAdapter.MyListViewHolder, position: Int){
            holder.bind(list[position])
    }
    override fun getItemCount():Int=list.size
}